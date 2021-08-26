/**
 * 
 */
package com.algaworks.algafood.domain.exception;

/**
 * @author Silvan de Jesus
 *
 */
public class EntidadeEmUsoException extends NegocioException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EntidadeEmUsoException(String mensagem) {
		super(mensagem);
	}
}
