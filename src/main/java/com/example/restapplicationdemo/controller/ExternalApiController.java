package com.example.restapplicationdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class ExternalApiController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/api/external")
    public Map<String, Object> getExternalData() {
        String url = "https://api.agify.io/?name=michael"; // API pública de exemplo
        return restTemplate.getForObject(url, Map.class);
    }
}
