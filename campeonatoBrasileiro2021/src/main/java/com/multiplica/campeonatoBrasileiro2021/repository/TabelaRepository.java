package com.multiplica.campeonatoBrasileiro2021.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.multiplica.campeonatoBrasileiro2021.model.Tabela;

public interface TabelaRepository extends JpaRepository<Tabela, Long> {

	Optional <Tabela> findByIdTime(int idTime);
	

}