package com.multiplica.campeonatoBrasileiro2021.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="jogador")
public class Jogador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private Date dataNascimento;
	private String localNascimento;
	private String nacionalidade;
	private float altura ;
	private String peDominante;
	private String posicao;
	private int numeracao;
	
	
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
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getLocalNascimento() {
		return localNascimento;
	}
	public void setLocalNascimento(String localNascimento) {
		this.localNascimento = localNascimento;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public String getPeDominante() {
		return peDominante;
	}
	public void setPeDominante(String peDominante) {
		this.peDominante = peDominante;
	}
	public String getPosicao() {
		return posicao;
	}
	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}
	public int getNumeracao() {
		return numeracao;
	}
	public void setNumeracao(int numeracao) {
		this.numeracao = numeracao;
	}
	
	@Override
	public String toString() {
		return "Jogador [id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", localNascimento="
				+ localNascimento + ", nacionalidade=" + nacionalidade + ", altura=" + altura + ", peDominante="
				+ peDominante + ", posicao=" + posicao + ", numeracao=" + numeracao + "]";
	}
}
