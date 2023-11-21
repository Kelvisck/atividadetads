package com.kelvisck.primeiroexemplo.shared;

public class PlanoDTO {
    
    private Integer id;
    private String nome;
    private String descricao;
    private Double valor;
    
    //#endregion 

    //#region getters e setters
    public Integer getId() {
        return id;
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

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String desc){
        this.descricao = desc;
    }
    
}
