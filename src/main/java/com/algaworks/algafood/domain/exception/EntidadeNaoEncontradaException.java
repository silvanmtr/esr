/**
 * 
 */
package com.algaworks.algafood.domain.exception;

/**
 * @author Silvan de Jesus
 *
 */
public abstract class EntidadeNaoEncontradaException extends NegocioException {

	private static final long serialVersionUID = 1L;

	public EntidadeNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
}