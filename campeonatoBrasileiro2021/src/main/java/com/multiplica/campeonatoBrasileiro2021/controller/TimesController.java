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

import com.multiplica.campeonatoBrasileiro2021.controller.form.TimesForm;
import com.multiplica.campeonatoBrasileiro2021.dto.TimesDto;
import com.multiplica.campeonatoBrasileiro2021.model.Times;
import com.multiplica.campeonatoBrasileiro2021.repository.TimesRepository;

@Controller
public class TimesController {

	@Autowired
	private TimesRepository timesRepository;

	@GetMapping("/times")
	@ResponseBody
	public List<Times> lista() {
		List<Times> times = timesRepository.findAll();
		return times;
	}

	@GetMapping("/times/nome")
	@ResponseBody
	public Times listaPorNome(String nomeTime) {
		Times times = timesRepository.findByNome(nomeTime);
		return times;
	}
	
	@GetMapping("/times/pais")
	@ResponseBody
	public List<Times> listaPorPais(String pais){
		List<Times> times = timesRepository.findByPais(pais);
		return times;
	}
	
	@GetMapping("/times/id/{id}")
	@ResponseBody
	public ResponseEntity<Optional<Times>> listaPorID(@PathVariable Long id){
		Optional<Times> times = timesRepository.findById(id);
		return ResponseEntity.ok(times);
	}
	
	@PostMapping("/times")
	@Transactional
	public ResponseEntity<Times> cadastra(@RequestBody @Valid TimesForm form,UriComponentsBuilder uriBilder ){
		Times times = form.converter();
		timesRepository.save(times);
		
		URI uri = uriBilder.path("/times/{id}").buildAndExpand(times.getId()).toUri();
		return ResponseEntity.created(uri).body(times);
	}
	
	@PutMapping("/times/{id}")
	@Transactional
	public ResponseEntity<TimesDto> altera(@PathVariable Long id, @RequestBody @Valid TimesForm form){
		Optional<Times> optional = timesRepository.findById(id);
		
		if(optional.isPresent()) {
			Times times = form.atualizar(id, timesRepository);
			return ResponseEntity.ok(new TimesDto(times));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/times/{id}")
	@Transactional
	public ResponseEntity<?> deleta(@PathVariable Long id){
		Optional<Times> optional = timesRepository.findById(id);

		if(optional.isPresent()) {
			timesRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}