package com.assignment.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.assignment.spring.clients.OpenweathermapClient;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
    @Bean
    public OpenweathermapClient openweathermapClient() {
    	return new OpenweathermapClient();
    }
}
