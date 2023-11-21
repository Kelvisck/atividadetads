package com.kelvisck.primeiroexemplo.view.model;

public class PlanoRequest {
    
    
    
    private String nome;
    private String descricao;
    private Double valor;
    //#endregion 

    //#region getters e setters
    
    public String getNome() {
        return nome;
    }
    
    public Double getValor() {
        return valor;
    }
    
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String desc){
        this.descricao = desc;
    }
    
}
