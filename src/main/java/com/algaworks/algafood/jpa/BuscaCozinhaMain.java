/**
 * 
 */
package com.algaworks.algafood.jpa;

import java.util.Optional;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgaFoodApplication;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.model.Cozinha;

/**
 * @author Silvan de Jesus
 *
 */
public class BuscaCozinhaMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext applicationContext =  new SpringApplicationBuilder(AlgaFoodApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);
		
		Optional<Cozinha> cozinha = cozinhaRepository.findById(1L);
		
		System.out.println(cozinha.get().getNome());
	}
}
