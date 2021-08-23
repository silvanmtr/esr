package com.algaworks.algafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.model.Cidade;

/**
 * 
 * @author Silvan de Jesus
 *
 */

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	
}