package com.example.micro.htl.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebAppConfig {

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
