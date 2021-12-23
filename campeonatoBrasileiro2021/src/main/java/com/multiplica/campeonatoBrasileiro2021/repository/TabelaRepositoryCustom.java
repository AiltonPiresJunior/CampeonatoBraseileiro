package com.multiplica.campeonatoBrasileiro2021.repository;

import javax.persistence.EntityManager;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public class TabelaRepositoryCustom {
	
	private final EntityManager entityManager;
	
	public TabelaRepositoryCustom(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void vitoria(@Param("idTime") int idTime, @Param("golsFeitos") int golsFeitos, @Param("golsSofridos") int golsSofridos) {
		var q = entityManager.createQuery("update tabela set pontuacao = pontuacao + 3, partidas = partidas + 1, vitorias = vitorias + 1, golsFeitos = golsFeitos + (:golsFeitos),	golsSofridos = golsSofridos + (:golsSofridos) ,saldoGols = saldoGols + ((:golsFeitos) - (:golsSofridos)) where idTime = :idTime");
		
		q.setParameter("idTime", idTime);
		q.setParameter("golsFeitos", golsFeitos);
		q.setParameter("golsSofridos", golsSofridos);
		
		var execute = q.executeUpdate();
	}

	public void derrota(@Param("idTime") int idTime, @Param("golsFeitos") int golsFeitos, @Param("golsSofridos") int golsSofridos) {
		var q = entityManager.createQuery("update tabela set partidas = partidas + 1, derrotas = derrotas + 1, golsFeitos = golsFeitos + (:golsFeitos),	golsSofridos = golsSofridos + (:golsSofridos) ,saldoGols = saldoGols + ((:golsFeitos) - (:golsSofridos)) where idTime = :idTime");
		
		q.setParameter("idTime", idTime);
		q.setParameter("golsFeitos", golsFeitos);
		q.setParameter("golsSofridos", golsSofridos);
		
		var execute = q.executeUpdate();
	}

	public void empate(@Param("idTime") int idTime, @Param("golsFeitos") int golsFeitos, @Param("golsSofridos") int golsSofridos) {
		var q = entityManager.createQuery("update tabela set pontuacao = pontuacao + 1, partidas = partidas + 1, empates = empates + 1, golsFeitos = golsFeitos + (:golsFeitos),	golsSofridos = golsSofridos + (:golsSofridos) ,saldoGols = saldoGols + ((:golsFeitos) - (:golsSofridos)) where idTime = :idTime");
		
		q.setParameter("idTime", idTime);
		q.setParameter("golsFeitos", golsFeitos);
		q.setParameter("golsSofridos", golsSofridos);
		
		var execute = q.executeUpdate();
	}
}
