package com.springreactivelearning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sidharth Das
 * created on  31/01/23
 */
@Service
public class GetRawData {

    @Autowired
    private WebClient webClient;

    public Mono<Object> getRaw() {
        return webClient.get()
                .retrieve()
                .bodyToMono(Object.class)
                .onErrorResume(x -> Mono.just("test"));


    }

    public Mono<Map<String, Object>> getMap() {
        Map<String, Object> m = new HashMap<>();
        m.put("test", 1);
        return Mono.just(m);


    }
}
