package com.multiplica.campeonatoBrasileiro2021.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.multiplica.campeonatoBrasileiro2021.model.Times;
import com.multiplica.campeonatoBrasileiro2021.repository.TimesRepository;

public class TimesForm {
	
	@NotNull @NotEmpty
	private String nome;
	@NotNull @NotEmpty
	private String cidade;
	@NotNull @NotEmpty
	private String estado;
	@NotNull @NotEmpty
	private String estadio;
	@NotNull @NotEmpty
	private int capacidade;
	@NotNull @NotEmpty
	private String pais;
	@NotNull @NotEmpty
	private String fundacao;
	@NotNull @NotEmpty
	private String historia;
	@NotNull @NotEmpty
	private int idElenco;
	@NotNull @NotEmpty
	private Long fotoEstadio;
	

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstadio() {
		return estadio;
	}

	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getFundacao() {
		return fundacao;
	}

	public void setFundacao(String fundacao) {
		this.fundacao = fundacao;
	}

	public String getHistoria() {
		return historia;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
	}

	public int getIdElenco() {
		return idElenco;
	}

	public void setIdElenco(int idElenco) {
		this.idElenco = idElenco;
	}

	public Long getFotoEstadio() {
		return fotoEstadio;
	}

	public void setFotoEstadio(Long fotoEstadio) {
		this.fotoEstadio = fotoEstadio;
	}

	public Times converter(){
		return new Times(nome, cidade, estado, estadio, capacidade, pais, fundacao, historia, idElenco, fotoEstadio);
	}
	
	public Times atualizar(Long id, TimesRepository timesRepository) {
		Times times = timesRepository.getOne(id);
		
		times.setNome(this.nome);
		times.setCidade(this.cidade);
		times.setEstado(this.estado);
		times.setEstadio(this.estadio);
		times.setCapacidade(this.capacidade);
		times.setPais(this.pais);
		times.setFundacao(this.fundacao);
		times.setHistoria(this.historia);
		times.setIdElenco(this.idElenco);
		times.setFotoEstadio(this.fotoEstadio);

		return times;
	}
}