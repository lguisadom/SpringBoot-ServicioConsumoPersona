package com.lagm.springboot.app.item.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
	private Persona persona;
	private Integer cantidad;
	
	public Double getSueldoTotal() {
		return persona.getSueldo() * cantidad.doubleValue();
	}
}
