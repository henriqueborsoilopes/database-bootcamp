package com.devsuperior.movieflix.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AplicationConfig {

	@Bean
	public ModelMapper getBean() {
		return new ModelMapper();
	}
}
