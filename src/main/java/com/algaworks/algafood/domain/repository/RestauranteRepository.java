/**
 * 
 */
package com.algaworks.algafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.model.Restaurante;

/**
 * @author Silvan de Jesus
 *
 */

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long>{
}
