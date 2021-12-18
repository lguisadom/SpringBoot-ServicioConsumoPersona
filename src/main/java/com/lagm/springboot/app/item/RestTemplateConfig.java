package com.lagm.springboot.app.item;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	// El nombre de la clase puede ser cualquiera
	
	@Bean(name = "clienteRest")
	public RestTemplate registrarRestTemplate() {
		return new RestTemplate();
	}
}
