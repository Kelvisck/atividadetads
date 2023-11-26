package com.kelvisck.primeiroexemplo;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class keyCloackToken {
    public String getToken() {
        String keycloakTokenUrl = "https://auth.facoffee.hsborges.dev/realms/facoffee/protocol/openid-connect/token";
        String clientId = "facoffee";
        String grantType = "password";
        String username = "seu_email"; // Substitua com o seu e-mail
        String password = "sua_senha"; // Substitua com a sua senha
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
        String response = restTemplate.postForObject(keycloakTokenUrl, request, String.class);

        // A resposta deve conter o token de acesso
        // Decodifique o token JWT para obter informações, se necessário

        return response;
    }
}
