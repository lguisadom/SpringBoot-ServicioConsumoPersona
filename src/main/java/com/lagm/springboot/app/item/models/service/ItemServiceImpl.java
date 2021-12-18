package com.lagm.springboot.app.item.models.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lagm.springboot.app.item.models.Item;
import com.lagm.springboot.app.item.models.Persona;

@Service("serviceRestTemplate")
public class ItemServiceImpl implements ItemService {

	private static Logger LOG = LoggerFactory.getLogger(ItemServiceImpl.class);
	
	@Autowired
	private RestTemplate clienteRest;
	
	@Override
	public List<Item> findAll() {
		LOG.info("Usando RestTemplate");
		
		Persona[] arrayPersonas = clienteRest.getForObject("http://localhost:8001/listar", Persona[].class);
		List<Persona> personas = Arrays.asList(arrayPersonas);
		/*
		 * Vamos a transformar la lista de personas en lista de items
		 * Usaremos jdk 8, el api stream (Programación Funcional)
		 * Los objetos de tipo List tienen el método stream() para convertirlas en un flujo
		 * Al flujo le aplicamos el método map() para cambiar cada elemento del flujo. Convirtiendo un objeto Persona a objeto Item
		 * Se pasa por argumento al map una función de flecha o expresión lambda:
		 * 	Por cada elemento se obtiene una persona
		 * ->
		 * 	Se convierte cada elemento en un objeto Item
		 * Ahora, queda convertir el stream (flujo) de vuelta a un tipo List mediante el método collect(Collectors.toList())
		 * */
		return personas.stream().map(persona -> new Item(persona, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		HashMap<String, String> pathVariables = new HashMap<>();
		pathVariables.put("id", id.toString());
		
		Persona persona = clienteRest.getForObject("http://localhost:8001/ver/{id}", Persona.class, pathVariables);
		return new Item(persona, cantidad);
	}

}
