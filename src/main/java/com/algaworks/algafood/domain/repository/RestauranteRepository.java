/**
 * 
 */
package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.model.Restaurante;

/**
 * @author Silvan de Jesus
 *
 */
public interface RestauranteRepository {
	List<Restaurante> listar();
	Restaurante buscar(Long id);
	Restaurante salvar(Restaurante cozinha);
	void remover(Restaurante cozinha);
}
