package com.cognizant.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GatewayController {

    private final RestTemplate restTemplate;

    public GatewayController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/accounts/{number}")
    public Object getAccount(@PathVariable String number) {
        String url = "http://localhost:8090/accounts/" + number;
        return restTemplate.getForObject(url, Object.class);
    }

    @GetMapping("/loans/{number}")
    public Object getLoan(@PathVariable String number) {
        String url = "http://localhost:8091/loans/" + number;
        return restTemplate.getForObject(url, Object.class);
    }
}
