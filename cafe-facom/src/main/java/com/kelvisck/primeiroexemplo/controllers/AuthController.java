package com.kelvisck.primeiroexemplo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kelvisck.primeiroexemplo.KeyCloackToken;




@Controller
public class AuthController {

    @Autowired
    private KeyCloackToken keyCloackToken;

    @RequestMapping("/https://auth.facoffee.hsborges.dev/realms/facoffee/protocol/openid-connect/token")
    @ResponseBody
    public String obterToken() {
        // Chama o método getToken() da sua classe
        String token = keyCloackToken.getToken();

        // Você pode fazer o que quiser com o token, como retorná-lo como resposta
        return "Token Obtido: " + token;
    }
}
