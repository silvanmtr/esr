package com.algaworks.algafood;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

import javax.validation.ConstraintViolationException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.algaworks.algafood.domain.exception.CozinhaNaoEncontradaException;
import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.service.CadastroCozinhaService;
import com.algaworks.algafood.model.Cozinha;
import com.algaworks.algafood.util.DatabaseCleaner;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application-test.properties")
public class CadastroCozinhaIT {

	@Autowired
	private CadastroCozinhaService cadastroCozinhaService;
	
	@Autowired
	private DatabaseCleaner databaseCleaner;
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@LocalServerPort
	private int port;
	
	
	@Before
	public void setup() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.port = port;
		RestAssured.basePath = "/cozinhas";
		
		databaseCleaner.clearTables();
		
		prepararDados();
	}
	
	@Test
	public void deveAtribuirId_QuandoCadastrarCozinhaComDadosCorretos() {
		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome("Chinesa");
		
		novaCozinha = cadastroCozinhaService.salvar(novaCozinha);
		
		assertThat(novaCozinha).isNotNull();
		assertThat(novaCozinha.getId()).isNotNull();
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void deveFalhar_QuandoCadastrarCozinhaSemNome() {
		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome(null);
		
		novaCozinha = cadastroCozinhaService.salvar(novaCozinha);
	}
	
	@Ignore
	@Test(expected = EntidadeEmUsoException.class)
	public void deveFalhar_QuandoExcluirCozinhaEmUso() {
		cadastroCozinhaService.excluir(1L);
	}

	@Test(expected = CozinhaNaoEncontradaException.class)
	public void deveFalhar_QuandoExcluirCozinhaInexistente() {
		cadastroCozinhaService.excluir(100L);
	}
	
	@Test
	public void deveRetornarStatus200_QuandoConsultarCozinhas() {
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get()
		.then()
			.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void deveConter2Cozinhas_QuandoConsultarCozinhas() {
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get()
		.then()
			.body("nome", hasSize(2))
			.body("nome", hasItems("Americana","Tailandesa"));
	}
	
	@Test
	public void deveRetornaStatus201_QuandoCadastrarCozinha() {
		given()
			.body("{\"nome\":\"Chinesa\" }")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		.when()
			.post()
		.then()
			.statusCode(HttpStatus.CREATED.value());	
	}
	
	@Test
	public void deveRetornarRespostaEStatusCorretos_QuandoCozinhaExistente() {
		given()
			.pathParam("cozinhaId", 2)
			.accept(ContentType.JSON)
		.when()
			.get("/{cozinhaId}")
		.then()
		.statusCode(HttpStatus.OK.value())
			.body("nome", equalTo("Americana"));
	}
	
	@Test
	public void deveRetornar404_QuandoCozinhaInexistente() {
		given()
			.pathParam("cozinhaId", 200)
			.accept(ContentType.JSON)
		.when()
			.get("/{cozinhaId}")
		.then()
		.statusCode(HttpStatus.NOT_FOUND.value());
	}
	
	private void prepararDados() {
		Cozinha cozinha1 =  new Cozinha();
		cozinha1.setNome("Tailandesa");
		cozinhaRepository.save(cozinha1);
		
		Cozinha cozinha2 =  new Cozinha();
		cozinha2.setNome("Americana");
		
		cozinhaRepository.save(cozinha2);
	}
}