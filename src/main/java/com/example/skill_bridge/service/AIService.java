package com.example.skill_bridge.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class AIService {

    private final WebClient wc;
    @Value("${openai.api.key:}")
    private String key;

    public AIService(WebClient wc) {
        this.wc = wc;
    }

    public Mono<String> generate(String prompt) {
        if (key == null || key.isBlank()) {
            return Mono.just("OpenAI key not configured");
        }
        var body = Map.of("model", "gpt-4o-mini", "messages", List.of(Map.of("role", "user", "content", prompt)));
        return wc.post()
                .uri("/chat/completions")
                .header("Authorization", "Bearer " + key)
                .bodyValue(body)
                .retrieve()
                .bodyToMono(Map.class)
                .map(m -> m.toString());
    }
}
