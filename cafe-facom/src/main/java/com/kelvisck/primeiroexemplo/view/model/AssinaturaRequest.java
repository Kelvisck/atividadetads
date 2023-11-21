package com.kelvisck.primeiroexemplo.view.model;

import java.time.LocalDate;

import com.kelvisck.primeiroexemplo.model.Plano;

public class AssinaturaRequest {

    
    private Integer idUsuario;
    private Plano plano;
    private boolean status;
    private LocalDate inicioData;
    private LocalDate fimData;
    
    
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
