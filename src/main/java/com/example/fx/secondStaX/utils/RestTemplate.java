package com.example.fx.secondStaX.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class RestTemplate {

    @Configuration
    public class AppConfig {
        @Bean
        public RestTemplate restTemplate() {
            return new RestTemplate();
        }
    }
}
