package com.kelvisck.primeiroexemplo;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class KeyCloackToken {
    
    
    public String getToken() {
        try {
            String keycloakTokenUrl = "https://auth.facoffee.hsborges.dev/realms/facoffee/protocol/openid-connect/token";
            String clientId = "facoffee";
            String grantType = "password";
            String username = "kelvisck.cabral@ufms.br";
            String password = "12345678";
            String scope = "openid";

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            String body = "client_id=" + clientId +
                    "&grant_type=" + grantType +
                    "&username=" + username +
                    "&password=" + password +
                    "&scope=" + scope;

            HttpEntity<String> request = new HttpEntity<>(body, headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(keycloakTokenUrl, request, String.class);

    
            String response = responseEntity.getBody();
            System.out.println("Resposta do servidor: " + response);

            return response;
        } catch (Exception e) {
            
            e.printStackTrace();
            return null; 
        }
    }
}