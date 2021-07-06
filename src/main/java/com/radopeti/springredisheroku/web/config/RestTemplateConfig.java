package com.radopeti.springredisheroku.web.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    public static final String ROOT_URI = "http://";

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().rootUri(ROOT_URI).build();
    }
}
