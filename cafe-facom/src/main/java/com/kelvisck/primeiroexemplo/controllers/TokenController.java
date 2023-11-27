package com.kelvisck.primeiroexemplo.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;


@RequestMapping("/token")
@RestController
public class TokenController {
    
    @PostMapping("/")
    public ResponseEntity<String> token(@RequestBody User user){
        
        HttpHeaders headers = new HttpHeaders();

        RestTemplate rt = new RestTemplate();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String > formData = new LinkedMultiValueMap<>();
        formData.add("client_id", user.client_id);
        formData.add("username", user.username);
        formData.add("password", user.password);
        formData.add("scope", user.scope);
        formData.add("grant_type", user.grantType);

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(formData, headers); 



        var result = rt.postForEntity("https://auth.facoffee.hsborges.dev/realms/facoffee/protocol/openid-connect/token",
        entity, String.class);

        return result;

    }

    public record User(String password, String client_id, String grantType, String username, String scope){

    }
}
