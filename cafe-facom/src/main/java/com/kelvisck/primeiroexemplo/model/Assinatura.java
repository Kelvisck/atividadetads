package com.kelvisck.primeiroexemplo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "assinatura")
public class Assinatura {
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  //estrategia automatico
    private Integer id;
    
    //simulando o id do usuario
    private Integer idUsuario;
    
    @ManyToOne
    @JoinColumn(name = "plano_id")
    private Plano plano;
    private boolean status;
    private LocalDate inicioData;
    private LocalDate fimData;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    public Plano getPlano() {
        return plano;
    }
    public void setPlano(Plano plano) {
        this.plano = plano;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public LocalDate getInicioData() {
        return inicioData;
    }
    public void setInicioData(LocalDate inicioData) {
        this.inicioData = inicioData;
    }
    public LocalDate getFimData() {
        return fimData;
    }
    public void setFimData(LocalDate fimData) {
        this.fimData = fimData;
    }

    

}
