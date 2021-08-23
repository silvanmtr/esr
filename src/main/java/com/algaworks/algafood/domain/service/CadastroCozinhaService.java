/**
 * 
 */
package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.model.Cozinha;

/**
 * @author Silvan de Jesus
 *
 */

@Service
public class CadastroCozinhaService {
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public Cozinha salvar(@RequestBody Cozinha cozinha) {
		
		return cozinhaRepository.salvar(cozinha);
	}
	
	public void excluir(Long id) {
		try {		
			cozinhaRepository.remover(id);
			
		}catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.format("Não Existe um cadastro de cozinha com um código %d", id));
		} 
		catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format("Cozinha de código %d não pode ser excluída pois está em uso", id));
		}
	}
}
