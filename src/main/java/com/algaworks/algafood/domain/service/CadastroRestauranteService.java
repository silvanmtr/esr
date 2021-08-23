/**
 * 
 */
package com.algaworks.algafood.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.model.Cozinha;
import com.algaworks.algafood.model.Restaurante;

/**
 * @author Silvan de Jesus
 *
 */
@Service
public class CadastroRestauranteService {

	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public Restaurante salvar(Restaurante restaurante) {
		
		Long cozinhaId = restaurante.getCozinha().getId();
		
		Optional<Cozinha> cozinha = cozinhaRepository.findById(cozinhaId);
		
		if(!cozinha.isEmpty()) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de cozinha para o código %d ", cozinhaId));
		}
		
		restaurante.setCozinha(cozinha.get());
		
		return restauranteRepository.save(restaurante);
	}
}
