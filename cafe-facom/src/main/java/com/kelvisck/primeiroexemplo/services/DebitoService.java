package com.kelvisck.primeiroexemplo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kelvisck.primeiroexemplo.model.Assinatura;
import com.kelvisck.primeiroexemplo.model.Debito;
import com.kelvisck.primeiroexemplo.model.Plano;
import com.kelvisck.primeiroexemplo.repository.DebitoRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class DebitoService {

    @Autowired
    private DebitoRepository debitoRepository;

    private final AssinaturasAtivasService assinaturasAtivasService;

    public DebitoService(AssinaturasAtivasService assinaturasAtivasService) {
        this.assinaturasAtivasService = assinaturasAtivasService;
    }

    public void gerarDebitosMensais() {
        LocalDate dataAtual = LocalDate.now();

        
        List<Assinatura> assinaturasAtivas = assinaturasAtivasService.obterAssinaturasAtivas();

        for (Assinatura assinatura : assinaturasAtivas) {
            
            Plano plano = assinatura.getPlano();

            
            BigDecimal valorDebitoMensal = BigDecimal.valueOf(plano.getValor());

            
            Debito debito = new Debito();
            debito.setValor(valorDebitoMensal);
            debito.setDataVencimento(dataAtual);
            debito.setUserId(assinatura.getIdUsuario()); 

            
            salvarDebito(debito);
        }
    }

    
    private void salvarDebito(Debito debito) {
        debitoRepository.save(debito);
    }
}
