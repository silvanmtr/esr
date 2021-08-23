/**
 * 
 */
package com.algaworks.algafood.jpa;

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
public class AlteracaoCozinhaMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext applicationContext =  new SpringApplicationBuilder(AlgaFoodApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);
		
		Cozinha cozinha = new Cozinha();
		cozinha.setId(1L);
		cozinha.setNome("Brasileira");
		
		cozinhaRepository.salvar(cozinha);

	}
}
