/**
 * 
 */
package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.model.Cozinha;

/**
 * @author Silvan de Jesus
 *
 */
public interface CozinhaRepository{

	List<Cozinha> listar();
	Cozinha buscar(Long id);
	Cozinha salvar(Cozinha cozinha);
	void remover(Long id);
}
