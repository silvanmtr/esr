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
public class InclusaoCozinhaMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext applicationContext =  new SpringApplicationBuilder(AlgaFoodApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);
		
		Cozinha cozinha1 = new Cozinha();
		cozinha1.setNome("Brasileira");
		
		Cozinha cozinha2 = new Cozinha();
		cozinha2.setNome("Japonesa");	
		
		cozinhaRepository.salvar(cozinha1);
		cozinhaRepository.salvar(cozinha2);		

	}
}
