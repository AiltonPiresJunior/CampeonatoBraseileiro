package com.multiplica.campeonatoBrasileiro2021.controller.form;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.multiplica.campeonatoBrasileiro2021.model.Partidas;
import com.multiplica.campeonatoBrasileiro2021.model.Tabela;
import com.multiplica.campeonatoBrasileiro2021.repository.PartidasRepository;
import com.multiplica.campeonatoBrasileiro2021.repository.TabelaRepository;

public class PartidasForm {
	
	@NotNull
	private int rodada;
	@NotNull
	private int idTimeMandante;
	@NotNull
	private int idTimeVisitante;
	@NotNull
	private int golsMandante;
	@NotNull
	private int golsVisitante;
	
	public int getRodada() {
		return rodada;
	}
	public void setRodada(int rodada) {
		this.rodada = rodada;
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
	
	public Partidas converter() {
		return new Partidas(rodada,idTimeMandante, idTimeVisitante,golsMandante, golsVisitante);
	}
	
	public List<Tabela> atualizaTabela(PartidasForm form, TabelaRepository tabelaRepository){
		
		
		Partidas partidas = form.converter();
		Tabela timeMandante = tabelaRepository.getOne((long) partidas.getIdTimeMandante());
		Tabela timeVisitante = tabelaRepository.getOne((long) partidas.getIdTimeVisitante());
		
		if(partidas.getGolsMandante() > partidas.getGolsVisitante()) {
			
			timeMandante.setPontuacao(timeMandante.getPontuacao() + 3);
			timeMandante.setPartidas(timeMandante.getPartidas() + 1);
			timeMandante.setVitorias(timeMandante.getVitorias() + 1);
			timeMandante.setGolsFeitos(timeMandante.getGolsFeitos() + partidas.getGolsMandante());
			timeMandante.setGolsSofridos(timeMandante.getGolsSofridos() + partidas.getGolsVisitante());
			timeMandante.setSaldoGols(timeMandante.getSaldoGols() + ( partidas.getGolsMandante() - partidas.getGolsVisitante()));
		
			timeVisitante.setPartidas(timeVisitante.getPartidas() + 1);
			timeVisitante.setDerrotas(timeVisitante.getDerrotas() + 1);
			timeVisitante.setGolsFeitos(timeVisitante.getGolsFeitos() + partidas.getGolsVisitante());
			timeVisitante.setGolsSofridos(timeVisitante.getGolsSofridos() + partidas.getGolsMandante());
			timeVisitante.setSaldoGols(timeVisitante.getSaldoGols() + ( partidas.getGolsVisitante() - partidas.getGolsMandante()));
		
		} else if(partidas.getGolsMandante() < partidas.getGolsVisitante()) {
			
			timeMandante.setPartidas(timeMandante.getPartidas() + 1);
			timeMandante.setDerrotas(timeMandante.getDerrotas() + 1);
			timeMandante.setGolsFeitos(timeMandante.getGolsFeitos() + partidas.getGolsMandante());
			timeMandante.setGolsSofridos(timeMandante.getGolsSofridos() + partidas.getGolsVisitante());
			timeMandante.setSaldoGols(timeMandante.getSaldoGols() + ( partidas.getGolsMandante() - partidas.getGolsVisitante()));
			
			timeVisitante.setPontuacao(timeVisitante.getPontuacao() + 3);
			timeVisitante.setPartidas(timeVisitante.getPartidas() + 1);
			timeVisitante.setVitorias(timeVisitante.getVitorias() + 1);
			timeVisitante.setGolsFeitos(timeVisitante.getGolsFeitos() + partidas.getGolsVisitante());
			timeVisitante.setGolsSofridos(timeVisitante.getGolsSofridos() + partidas.getGolsMandante());
			timeVisitante.setSaldoGols(timeVisitante.getSaldoGols() + ( partidas.getGolsVisitante() - partidas.getGolsMandante()));
			
		} else if(partidas.getGolsMandante() == partidas.getGolsVisitante()) {
			
			timeMandante.setPontuacao(timeMandante.getPontuacao() + 1);
			timeMandante.setPartidas(timeMandante.getPartidas() + 1);
			timeMandante.setEmpates(timeMandante.getEmpates() + 1);
			timeMandante.setGolsFeitos(timeMandante.getGolsFeitos() + partidas.getGolsMandante());
			timeMandante.setGolsSofridos(timeMandante.getGolsSofridos() + partidas.getGolsVisitante());
			timeMandante.setSaldoGols(timeMandante.getSaldoGols() + ( partidas.getGolsMandante() - partidas.getGolsVisitante()));
			
			timeVisitante.setPontuacao(timeVisitante.getPontuacao() + 1);
			timeVisitante.setPartidas(timeVisitante.getPartidas() + 1);
			timeVisitante.setEmpates(timeVisitante.getEmpates() + 1);
			timeVisitante.setGolsFeitos(timeVisitante.getGolsFeitos() + partidas.getGolsVisitante());
			timeVisitante.setGolsSofridos(timeVisitante.getGolsSofridos() + partidas.getGolsMandante());
			timeVisitante.setSaldoGols(timeVisitante.getSaldoGols() + ( partidas.getGolsVisitante() - partidas.getGolsMandante()));
		}
		
		List lista = new ArrayList();
		lista.add(timeMandante);
		lista.add(timeVisitante);
		
		return lista;
	}

	public Partidas atualizar(Long id2, PartidasRepository partidasRepository) {
		Partidas partidas = partidasRepository.getOne(id2);
		partidas.setRodada(this.rodada);
		partidas.setIdTimeMandante(this.idTimeMandante);
		partidas.setIdTimeVisitante(this.idTimeVisitante);
		partidas.setGolsMandante(this.golsMandante);
		partidas.setGolsVisitante(this.golsVisitante);
		
		return partidas;
	}
	
	public List<Tabela> zerar(Long id2, PartidasRepository partidasRepository, TabelaRepository tabelaRepository) {
		
		Partidas partidas = partidasRepository.getOne(id2);

		Tabela tabelaMandante = tabelaRepository.getOne((long) partidas.getIdTimeMandante());
		Tabela tabelaVisitante = tabelaRepository.getOne((long) partidas.getIdTimeVisitante());
		
		if(partidas.getGolsMandante() > partidas.getGolsVisitante()) {
			
			tabelaMandante.setPontuacao(tabelaMandante.getPontuacao() - 3);
			tabelaMandante.setPartidas(tabelaMandante.getPartidas() - 1);
			tabelaMandante.setVitorias(tabelaMandante.getVitorias() - 1);
			tabelaMandante.setGolsFeitos(tabelaMandante.getGolsFeitos() - partidas.getGolsMandante());
			tabelaMandante.setGolsSofridos(tabelaMandante.getGolsSofridos() - partidas.getGolsVisitante());
			tabelaMandante.setSaldoGols(tabelaMandante.getSaldoGols() - (partidas.getGolsMandante() - partidas.getGolsVisitante()));
			
			tabelaVisitante.setPartidas(tabelaVisitante.getPartidas() - 1);
			tabelaVisitante.setDerrotas(tabelaVisitante.getDerrotas() - 1);
			tabelaVisitante.setGolsFeitos(tabelaVisitante.getGolsFeitos() - partidas.getGolsVisitante());
			tabelaVisitante.setGolsSofridos(tabelaVisitante.getGolsSofridos() - partidas.getGolsMandante());
			tabelaVisitante.setSaldoGols(tabelaVisitante.getSaldoGols() - (partidas.getGolsVisitante() - partidas.getGolsMandante()));
			
		} else if (partidas.getGolsMandante() < partidas.getGolsVisitante()) {
			tabelaMandante.setPartidas(tabelaMandante.getPartidas() - 1);
			tabelaMandante.setDerrotas(tabelaMandante.getDerrotas() - 1);
			tabelaMandante.setGolsFeitos(tabelaMandante.getGolsFeitos() - partidas.getGolsMandante());
			tabelaMandante.setGolsSofridos(tabelaMandante.getGolsSofridos() - partidas.getGolsVisitante());
			tabelaMandante.setSaldoGols(tabelaMandante.getSaldoGols() - (partidas.getGolsMandante() - partidas.getGolsVisitante()));
			
			tabelaVisitante.setPontuacao(tabelaVisitante.getPontuacao() - 3);
			tabelaVisitante.setPartidas(tabelaVisitante.getPartidas() - 1);
			tabelaVisitante.setVitorias(tabelaVisitante.getVitorias() - 1);
			tabelaVisitante.setGolsFeitos(tabelaVisitante.getGolsFeitos() - partidas.getGolsVisitante());
			tabelaVisitante.setGolsSofridos(tabelaVisitante.getGolsSofridos() - partidas.getGolsMandante());
			tabelaVisitante.setSaldoGols(tabelaVisitante.getSaldoGols() - (partidas.getGolsVisitante() - partidas.getGolsMandante()));
			
		} else if(partidas.getGolsMandante() == partidas.getGolsVisitante()) {

			tabelaMandante.setPontuacao(tabelaMandante.getPontuacao() - 1);
			tabelaMandante.setPartidas(tabelaMandante.getPartidas() - 1);
			tabelaMandante.setEmpates(tabelaMandante.getEmpates() - 1);
			tabelaMandante.setGolsFeitos(tabelaMandante.getGolsFeitos() - partidas.getGolsMandante());
			tabelaMandante.setGolsSofridos(tabelaMandante.getGolsSofridos() - partidas.getGolsVisitante());
			tabelaMandante.setSaldoGols(tabelaMandante.getSaldoGols() - (partidas.getGolsMandante() - partidas.getGolsVisitante()));

			tabelaVisitante.setPontuacao(tabelaVisitante.getPontuacao() - 1);
			tabelaVisitante.setPartidas(tabelaVisitante.getPartidas() - 1);
			tabelaVisitante.setEmpates(tabelaVisitante.getEmpates() - 1);
			tabelaVisitante.setGolsFeitos(tabelaVisitante.getGolsFeitos() - partidas.getGolsVisitante());
			tabelaVisitante.setGolsSofridos(tabelaVisitante.getGolsSofridos() - partidas.getGolsMandante());
			tabelaVisitante.setSaldoGols(tabelaVisitante.getSaldoGols() - (partidas.getGolsVisitante() - partidas.getGolsMandante()));
	}
		List lista = new ArrayList();
		lista.add(tabelaVisitante);
		lista.add(tabelaMandante);
		
		return lista;
	}
}
