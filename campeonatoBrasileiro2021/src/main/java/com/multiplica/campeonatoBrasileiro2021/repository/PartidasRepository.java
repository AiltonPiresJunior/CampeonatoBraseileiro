package com.multiplica.campeonatoBrasileiro2021.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.multiplica.campeonatoBrasileiro2021.model.Partidas;

public interface PartidasRepository extends JpaRepository<Partidas, Long>{

	List<Partidas> findByRodada(int rodada);

	Optional <Partidas> findByIdTimeMandante(int idTime);

	Optional <Partidas> findByIdTimeVisitante(int idTime);
	
	Optional <Partidas> findById(int id);

	@Query(value = "select top (1) * from partidas order by id desc", nativeQuery = true)
	Partidas chama(Partidas partidas);
	
}
