package com.radopeti.springredisheroku.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Value("${parking.service.base.url}")
    private String ROOT_URI;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().rootUri(ROOT_URI).build();
    }
}
