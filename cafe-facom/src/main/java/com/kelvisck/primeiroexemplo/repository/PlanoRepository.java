package com.kelvisck.primeiroexemplo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kelvisck.primeiroexemplo.model.Plano;

@Repository
public interface PlanoRepository extends JpaRepository<Plano, Integer>{
    
}
