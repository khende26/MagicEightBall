package com.detroitlabs.magiceightball.service;

import com.detroitlabs.magiceightball.model.Fortune;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;

@Component
public class DailyFortune {
    public Fortune fetchDailyFortune(String sign) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpsHeaders = new HttpHeaders();
        httpsHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpsHeaders.add("User-Agent","Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", httpsHeaders);
        ResponseEntity responseEntity = restTemplate.exchange("https://aztro.sameerkumar.website?sign="+ sign +"&day=today", HttpMethod.POST, entity, String.class);
        return new ObjectMapper().readValue(responseEntity.getBody().toString(), Fortune.class);



    }
}
