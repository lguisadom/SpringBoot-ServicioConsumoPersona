package com.lagm.springboot.app.item.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lagm.springboot.app.item.models.Persona;

@FeignClient(name = "servicio-personas", url = "localhost:8001")
public interface PersonaClienteRest {
	@GetMapping("/listar")
	public List<Persona> listar();
	
	@GetMapping("/ver/{id}")
	public Persona detalle(@PathVariable Long id);
}
