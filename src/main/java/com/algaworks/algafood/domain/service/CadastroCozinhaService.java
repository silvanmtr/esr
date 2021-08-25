/**
 * 
 */
package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
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
	
	private static final String MSG_COZINHA_EM_USO 	= "Cozinha de código %d não pode ser removida, pois está em uso";

	private static final String MSG_COZINHA_NAO_ENCONTRADA 	= "Não existe um cadastro de cozinha com código %d";

	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public Cozinha salvar(@RequestBody Cozinha cozinha) {
		
		return cozinhaRepository.save(cozinha);
	}
	
	public void excluir(Long id) {
		try {
			cozinhaRepository.deleteById(id);
			
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.format(MSG_COZINHA_NAO_ENCONTRADA, id));
		
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(MSG_COZINHA_EM_USO, id));
		}
	}

	/**
	 * Busca uma cozinha pelo ID, senão encontrar lança uma exceção.
	 * 
	 * @param cozinhaId
	 * @return
	 */
	public Cozinha buscarOuFalhar(Long cozinhaId) {
		return cozinhaRepository.findById(cozinhaId)
			.orElseThrow(() -> new EntidadeNaoEncontradaException(String.format(MSG_COZINHA_NAO_ENCONTRADA, cozinhaId)));
	}
}
