/**
 * 
 */
package com.algaworks.algafood.jpa;

import java.util.List;

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
public class ConsultaCozinhaMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext applicationContext =  new SpringApplicationBuilder(AlgaFoodApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);
		
		List<Cozinha> cozinhas = cozinhaRepository.findAll();
		
		System.out.println(cozinhas.size());

	}
	


}
