package com.algaworks.algafood.domain.repository;


import java.util.List;

import com.algaworks.algafood.model.Estado;

/**
 * 
 * @author Silvan de Jesus
 *
 */
public interface EstadoRepository {

	List<Estado> listar();
	Estado buscar(Long id);
	Estado salvar(Estado estado);
	void remover(Long id);	
}