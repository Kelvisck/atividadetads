package com.kelvisck.primeiroexemplo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kelvisck.primeiroexemplo.model.Assinatura;

@Repository
public interface AssinaturaRepository extends JpaRepository<Assinatura, Integer>{
    
}
