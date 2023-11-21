package com.kelvisck.primeiroexemplo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;   

@Entity
public class Plano {

    //#region Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  //estrategia automatico
    private Integer id;
    private String nome;
    private String descricao;
    private Double valor;
    
    //#endregion 

    //#region getters e setters
    public Integer getId() {
        return id;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String desc){
        this.descricao = desc;
    }
    
    public String getNome() {
        return nome;
    }
    
    public Double getValor() {
        return valor;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setValor(Double valor) {
        this.valor = valor;
    }
    

    
    //#endregion

}
