/**
 * 
 */
package com.algaworks.algafood.api.model.mixin;

import com.algaworks.algafood.model.Estado;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Silvan de Jesus
 *
 */
public class CidadeMixin {
	@JsonIgnoreProperties(value = "nome", allowGetters = true)
	private Estado estado;
}
