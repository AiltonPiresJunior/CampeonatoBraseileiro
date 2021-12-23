package com.multiplica.campeonatoBrasileiro2021.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.multiplica.campeonatoBrasileiro2021.repository.PartidasRepository;

@Entity
@Table(name ="Partidas")
public class Partidas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int rodada;
	private int idTimeMandante;
	private int idTimeVisitante;
	private int golsMandante;
	private int golsVisitante;
	
	public Partidas() {
		
	}

	public Partidas(int rodada, int idTimeMandante, int idTimeVisitante, int golsMandante, int golsVisitante) {
		this.rodada = rodada;
		this.idTimeMandante = idTimeMandante;
		this.idTimeVisitante = idTimeVisitante;
		this.golsMandante = golsMandante;
		this.golsVisitante = golsVisitante;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getRodada() {
		return rodada;
	}
	public void setRodada(int rodada) {
		this.rodada = rodada;
	}
	public int getGolsMandante() {
		return golsMandante;
	}
	public void setGolsMandante(int golsMandante) {
		this.golsMandante = golsMandante;
	}
	public int getGolsVisitante() {
		return golsVisitante;
	}
	public void setGolsVisitante(int golsVisitante) {
		this.golsVisitante = golsVisitante;
	}	

	public int getIdTimeMandante() {
		return idTimeMandante;
	}
	public void setIdTimeMandante(int idTimeMandante) {
		this.idTimeMandante = idTimeMandante;
	}
	public int getIdTimeVisitante() {
		return idTimeVisitante;
	}
	public void setIdTimeVisitante(int idTimeVisitante) {
		this.idTimeVisitante = idTimeVisitante;
	}
	@Override
	public String toString() {
		return "Partidas [id=" + id + ", rodada=" + rodada + ", idTimeMandante=" + idTimeMandante + ", idTimeVisitante="
				+ idTimeVisitante + ", golsMandante=" + golsMandante + ", golsVisitante=" + golsVisitante + "]";
	}
}

