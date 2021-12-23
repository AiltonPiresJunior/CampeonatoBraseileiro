package com.multiplica.campeonatoBrasileiro2021.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.multiplica.campeonatoBrasileiro2021.model.Tabela;
import com.multiplica.campeonatoBrasileiro2021.repository.TabelaRepository;

@Controller
public class TabelaController {
	
	@Autowired
	private TabelaRepository tabelaRepository;
	
	@GetMapping("/tabela")
	@ResponseBody
	public List<Tabela> lista(){
		List<Tabela> tabela = tabelaRepository.findAll();
		return tabela;
	}
	
	@GetMapping("/tabela/idTime")
	@ResponseBody
	public ResponseEntity<Tabela> listaPorIdTime(int idTime) {
		
		Optional<Tabela> optional = tabelaRepository.findByIdTime(idTime);
		
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		
		return ResponseEntity.notFound().build();
	}
}