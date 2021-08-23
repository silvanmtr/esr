/**
 * 
 */
package com.algaworks.algafood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgaFoodApplication;
import com.algaworks.algafood.domain.service.CadastroCozinhaService;
import com.algaworks.algafood.model.Cozinha;

/**
 * @author Silvan de Jesus
 *
 */
public class ExclusaoCozinhaMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext applicationContext =  new SpringApplicationBuilder(AlgaFoodApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CadastroCozinhaService cadastroCozinha = applicationContext.getBean(CadastroCozinhaService.class);
		
		Cozinha cozinha = new Cozinha();
		cozinha.setId(1L);
		
		cadastroCozinha.excluir(cozinha.getId());

	}
}
