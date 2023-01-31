package com.springreactivelearning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author Sidharth Das
 * created on  31/01/23
 */
@Configuration
public class WebclientConfig {

    @Bean
    public WebClient webClient() {
        return WebClient.create("https://jsonplaceholder.typicode.com/todos/1").mutate().build();
    }
}
