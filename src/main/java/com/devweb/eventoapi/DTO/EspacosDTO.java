package com.devweb.eventoapi.DTO;

public class EspacosDTO {
    public Long id;
    public String nome;
    public String localizacao;
    public int capacidade;
    public Long edicaoId; 
    
    public int getCapacidade() {
      return capacidade;
    }
    public Long getEdicaoId() {
      return edicaoId;
    }
    public Long getId() {
      return id;
    }
    public String getLocalizacao() {
      return localizacao;
    }
    public String getNome() {
      return nome;
    }
    public void setCapacidade(int capacidade) {
      this.capacidade = capacidade;
    }
    public void setEdicaoId(Long edicaoId) {
      this.edicaoId = edicaoId;
    }
    public void setId(Long id) {
      this.id = id;
    }
    public void setLocalizacao(String localizacao) {
      this.localizacao = localizacao;
    }
    public void setNome(String nome) {
      this.nome = nome;
    }
}
