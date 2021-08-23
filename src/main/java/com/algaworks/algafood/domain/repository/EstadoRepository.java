package com.algaworks.algafood.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.model.Estado;

/**
 * 
 * @author Silvan de Jesus
 *
 */
@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>{
}