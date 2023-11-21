package com.kelvisck.primeiroexemplo.services;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.kelvisck.primeiroexemplo.model.Assinatura;
import com.kelvisck.primeiroexemplo.repository.AssinaturaRepository;

@Service
public class AssinaturasAtivasService {
    
    private final AssinaturaRepository assinaturaRepository;

    public AssinaturasAtivasService(AssinaturaRepository assinaturaRepository) {
        this.assinaturaRepository = assinaturaRepository;
    }

    public List<Assinatura> obterAssinaturasAtivas() {
        
        List<Assinatura> todasAssinaturas = assinaturaRepository.findAll();
        List<Assinatura> assinaturasAtivas = new ArrayList<>();

        for (Assinatura assinatura : todasAssinaturas) {
            if (assinatura.isStatus()) {  
                assinaturasAtivas.add(assinatura);
            }
        }

        return assinaturasAtivas;

    }
    
}
