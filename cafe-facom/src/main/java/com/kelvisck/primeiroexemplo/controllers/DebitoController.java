package com.kelvisck.primeiroexemplo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.kelvisck.primeiroexemplo.services.DebitoService;

@RestController
@RequestMapping("/api/debito")
public class DebitoController {

    @Autowired
    private DebitoService debitoService;

    
    @PostMapping
    public ResponseEntity<String> gerarDebitosMensais() {
        debitoService.gerarDebitosMensais();
        return ResponseEntity.ok("Débitos mensais gerados com sucesso!");
    }

    
}
