package com.demo.aiqademo;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@Service
public class OllamaService {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String OLLAMA_URL = "http://localhost:11434/api/generate";

    public String ask(String question) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "phi4-mini:3.8b");
        requestBody.put("prompt", question);
        requestBody.put("stream", false);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(OLLAMA_URL, entity, Map.class);

        if (response.getBody() != null && response.getBody().containsKey("response")) {
            return response.getBody().get("response").toString();
        }
        return "模型调用失败，请检查 Ollama 是否运行";
    }
}