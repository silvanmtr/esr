/**
 * 
 */
package com.algaworks.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.model.Restaurante;

/**
 * @author Silvan de Jesus
 *
 */

@Repository
public interface RestauranteRepository extends CustomJpaRepository<Restaurante, Long>, RestauranteRepositoryQueries, JpaSpecificationExecutor<Restaurante>{
	List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);
	
	List<Restaurante> findByNomeContainingAndCozinhaId(String nome, Long cozinha);
	
	Optional<Restaurante> findFirstByNomeContaining(String nome);
	
	List<Restaurante> findTop2ByNomeContaining(String nome);

	int countByCozinhaId(Long cozinha);
	
	//@Query("from Restaurante where nome like %:nome% and cozinha.id = :id")
	List<Restaurante> consultarPorNome(String nome, @Param("id") Long cozinha);
}
