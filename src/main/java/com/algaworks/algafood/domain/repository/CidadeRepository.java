package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.model.Cidade;

/**
 * 
 * @author Silvan de Jesus
 *
 */
public interface CidadeRepository {

	List<Cidade> listar();
	Cidade buscar(Long id);
	Cidade salvar(Cidade cidade);
	void remover(Long id);
	
}