package com.multiplica.campeonatoBrasileiro2021.controller.form;

import com.multiplica.campeonatoBrasileiro2021.model.Partidas;
import com.multiplica.campeonatoBrasileiro2021.model.Tabela;
import com.multiplica.campeonatoBrasileiro2021.repository.PartidasRepository;
import com.multiplica.campeonatoBrasileiro2021.repository.TabelaRepository;

public class TabelaForm {
	
	private int pontuacao;
	private int partidas;
	private int vitorias;
	private int empates;
	private int derrotas;
	private int saldoGols;
	
	public int getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	public int getPartidas() {
		return partidas;
	}
	public void setPartidas(int partidas) {
		this.partidas = partidas;
	}
	public int getVitorias() {
		return vitorias;
	}
	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}
	public int getEmpates() {
		return empates;
	}
	public void setEmpates(int empates) {
		this.empates = empates;
	}
	public int getDerrotas() {
		return derrotas;
	}
	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}
	public int getSaldoGols() {
		return saldoGols;
	}
	public void setSaldoGols(int saldoGols) {
		this.saldoGols = saldoGols;
	}
	
	public Tabela vitoria(Long id, TabelaRepository tabelaRepository) {
		Tabela tabela = tabelaRepository.getOne(id);
		tabela.setPontuacao(tabela.getPontuacao() + 3);
		tabela.setPartidas(tabela.getPartidas() + 1);
		tabela.setVitorias(tabela.getVitorias() + 1);
		
		return tabela;
	}
}
