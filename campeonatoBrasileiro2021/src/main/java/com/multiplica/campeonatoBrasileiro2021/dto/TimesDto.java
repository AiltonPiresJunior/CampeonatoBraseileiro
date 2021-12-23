package com.multiplica.campeonatoBrasileiro2021.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.multiplica.campeonatoBrasileiro2021.model.Times;

public class TimesDto {

	private Long id;
	private String nome;
	private String pais;
	private String estadio;
	
	public TimesDto(Times time) {
		this.id = time.getId();
		this.nome = time.getNome();
		this.pais = time.getPais();
		this.estadio = time.getEstadio();
		
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getEstadio() {
		return estadio;
	}
	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}

	@Override
	public String toString() {
		return "TimesDto [id=" + id + ", nome=" + nome + ", pais=" + pais + ", estadio=" + estadio + "]";
	}

	public static List<TimesDto> converter(List<Times> times) {
		return times.stream().map(TimesDto::new).collect(Collectors.toList());
	}
}