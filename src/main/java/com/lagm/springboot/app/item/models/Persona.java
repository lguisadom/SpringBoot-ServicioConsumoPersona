package com.lagm.springboot.app.item.models;

import java.util.Date;

import lombok.Data;

@Data
public class Persona {
	private Long idPersona;
	private String nombre;
	private Double estatura;
	private Date fechaNacimiento;
	private Double sueldo;
}
