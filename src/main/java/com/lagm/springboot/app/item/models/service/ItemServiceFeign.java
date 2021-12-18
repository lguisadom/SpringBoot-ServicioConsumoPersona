package com.lagm.springboot.app.item.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lagm.springboot.app.item.clientes.PersonaClienteRest;
import com.lagm.springboot.app.item.models.Item;

@Service("serviceFeign")
// @Primary // Indica la implementación por defecto a inyectar cuando no se especifica el nombre del componente
public class ItemServiceFeign implements ItemService {

	private static Logger LOG = LoggerFactory.getLogger(ItemServiceFeign.class);
	
	@Autowired
	private PersonaClienteRest clienteFeign;
	
	@Override
	public List<Item> findAll() {
		LOG.info("Usando Feign");
		return clienteFeign.listar().stream().map(persona -> new Item(persona, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		return new Item(clienteFeign.detalle(id), cantidad);
	}

}
