package org.example.service_c_react;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class SpringConfig {

    @Bean
    public WebClient.Builder webClient() {
        return WebClient.builder();
    }
}
