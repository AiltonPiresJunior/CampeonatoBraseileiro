package com.multiplica.campeonatoBrasileiro2021.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Times")
public class Times {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String cidade;
	private String estado;
	private String estadio;
	private int capacidade;
	private String pais;
	private String fundacao;
	private String historia;
	private int idElenco;
	private Long fotoEstadio;
	
	public Times() {
	}
	

	
	public Times(String nome, String cidade, String estado, String estadio, int capacidade, String pais,
			String fundacao, String historia, int idElenco, Long fotoEstadio) {
		this.nome = nome;
		this.cidade = cidade;
		this.estado = estado;
		this.estadio = estadio;
		this.capacidade = capacidade;
		this.pais = pais;
		this.fundacao = fundacao;
		this.historia = historia;
		this.idElenco = idElenco;
		this.fotoEstadio = fotoEstadio;
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
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

	@Override
	public String toString() {
		return "Times [id=" + id + ", nome=" + nome + ", cidade=" + cidade + ", estado=" + estado + ", estadio="
				+ estadio + ", capacidade=" + capacidade + ", pais=" + pais + ", fundacao=" + fundacao + ", historia="
				+ historia + ", idElenco=" + idElenco + ", fotoEstadio=" + fotoEstadio + "]";
	}
}
