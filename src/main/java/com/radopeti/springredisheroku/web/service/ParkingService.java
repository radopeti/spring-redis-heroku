package com.radopeti.springredisheroku.web.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class ParkingService {

    private final RestTemplate restTemplate;

    public ParkingService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getInformation(String identType, String ident) {
        Map<String, String> uriVars = new HashMap<>();
        uriVars.put("identType", identType);
        uriVars.put("ident", ident);
        return restTemplate
                .getForObject("/information/{identType}/{ident}", String.class, uriVars);
    }

}
