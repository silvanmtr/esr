/**
 * 
 */
package com.algaworks.algafood.api.model.mixin;

import java.util.List;

import com.algaworks.algafood.model.Restaurante;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Silvan de Jesus
 *
 */
public class CozinhaMixin {
	@JsonIgnore
	private List<Restaurante> restaurantes;
}
