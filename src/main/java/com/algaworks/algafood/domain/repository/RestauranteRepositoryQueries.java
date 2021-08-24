/**
 * 
 */
package com.algaworks.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import com.algaworks.algafood.model.Restaurante;

/**
 * @author Silvan de Jesus
 *
 */
public interface RestauranteRepositoryQueries {
	List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);
	
	List<Restaurante> findComFretaGratis(String nome);
}	
