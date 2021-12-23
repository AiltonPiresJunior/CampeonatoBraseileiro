package com.multiplica.campeonatoBrasileiro2021.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.multiplica.campeonatoBrasileiro2021.controller.form.PartidasForm;
import com.multiplica.campeonatoBrasileiro2021.model.Partidas;
import com.multiplica.campeonatoBrasileiro2021.model.Tabela;
import com.multiplica.campeonatoBrasileiro2021.repository.PartidasRepository;
import com.multiplica.campeonatoBrasileiro2021.repository.TabelaRepository;

@Controller
public class PartidasController {

	@Autowired
	private PartidasRepository partidasRepository;
	private TabelaRepository tabelaRepository;
	
	public PartidasController(PartidasRepository partidasRepository, TabelaRepository tabelaRepository) {
		this.partidasRepository = partidasRepository;
		this.tabelaRepository = tabelaRepository;
	}

	@GetMapping("/partidas")
	@ResponseBody
	public List<Partidas> lista(){
		List<Partidas> partidas = partidasRepository.findAll();

		return partidas;
	}

	@GetMapping("/partidas/rodada")
	@ResponseBody
	public List<Partidas> listaPorRodada(int rodada){
		List<Partidas> partidas = partidasRepository.findByRodada(rodada);

		return partidas;
	}

	@GetMapping("/partidas/idTime")
	@ResponseBody
	public ResponseEntity<Partidas> listaPorTime(int idTime){
		Optional<Partidas> optional1 = partidasRepository.findByIdTimeMandante(idTime);
		Optional<Partidas> optional2 = partidasRepository.findByIdTimeVisitante(idTime);
		if(optional1.isPresent()) {
			return ResponseEntity.ok(optional1.get());
		}else if(optional2.isPresent()){
			return ResponseEntity.ok(optional2.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/partidas")
	@Transactional
	public ResponseEntity<Partidas> cadastra(@RequestBody @Valid PartidasForm form, UriComponentsBuilder uriBilder){
		Partidas partidas = form.converter();
		partidasRepository.save(partidas);
		
		List<Tabela> atualizaTabela = form.atualizaTabela(form, tabelaRepository);
		
		tabelaRepository.saveAll(atualizaTabela);

		URI uri = uriBilder.path("/partidas/{id}").buildAndExpand(partidas.getId()).toUri();

		return ResponseEntity.created(uri).body(partidas);
	}

	@PutMapping("/partidas/{id}")
	@Transactional
	public ResponseEntity<Partidas> altera(@PathVariable Long id, @RequestBody @Valid PartidasForm form){
		Optional<Partidas> optional = partidasRepository.findById(id);

		if(optional.isPresent()) {
			
			List<Tabela> zerado = form.zerar(id, partidasRepository, tabelaRepository);
			
			tabelaRepository.saveAll(zerado);
			
			Partidas partidas = form.atualizar(id, partidasRepository);
			
			partidasRepository.save(partidas);
			
			List<Tabela> tabela = form.atualizaTabela(form, tabelaRepository);
			
			tabelaRepository.saveAll(tabela);
			
			
			return ResponseEntity.ok(partidas);
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/partidas/{id}")
	@Transactional
	public ResponseEntity<Partidas> deleta(@PathVariable Long id){
		Optional<Partidas> optional = partidasRepository.findById(id);

		if(optional.isPresent()) {
			
			Partidas partidas = partidasRepository.getOne(id);
			
			PartidasForm form = new PartidasForm();
			form.setRodada(partidas.getRodada());
			form.setIdTimeMandante(partidas.getIdTimeMandante());
			form.setIdTimeVisitante(partidas.getIdTimeVisitante());
			form.setGolsMandante(partidas.getGolsMandante());
			form.setGolsVisitante(partidas.getGolsVisitante());
			
			
			List<Tabela> tabela = form.zerar(id, partidasRepository, tabelaRepository);
			
			tabelaRepository.saveAll(tabela);
			
			partidasRepository.deleteById(id);
			
			
			
			
			
			return ResponseEntity.ok().build();
			
			
			
		}

		return ResponseEntity.notFound().build();
	}
}