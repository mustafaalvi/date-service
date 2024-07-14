package com.hour.carmedy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Value("${chatgpt.api.key}")
    private String apiKey;

    @Bean
    public RestClient restClient() {
        return RestClient.builder()
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .defaultHeader("Content-Type","application/json" )
                .build();
    }
}
