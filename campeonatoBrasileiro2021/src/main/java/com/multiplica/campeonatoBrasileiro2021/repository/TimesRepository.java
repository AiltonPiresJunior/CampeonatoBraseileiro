package com.multiplica.campeonatoBrasileiro2021.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiplica.campeonatoBrasileiro2021.model.Times;

public interface TimesRepository extends JpaRepository<Times, Long>{
	
	Times findByNome(String nomeTime);

	List<Times> findByPais(String pais);
	
	List<Times> findById(int id);

}
