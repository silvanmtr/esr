/**
 * 
 */
package com.algaworks.algafood.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.model.Cozinha;

/**
 * @author Silvan de Jesus
 *
 */

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long>{

	Optional<Cozinha> findByNome(String nome);
	
	List<Cozinha> findTodasByNomeContaining(String nome);
	
	boolean existsByNome(String nome);
}
