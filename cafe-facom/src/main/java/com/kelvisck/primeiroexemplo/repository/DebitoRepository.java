package com.kelvisck.primeiroexemplo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.kelvisck.primeiroexemplo.model.Debito;

@Repository
public interface DebitoRepository extends JpaRepository<Debito, Integer>{
    
}
