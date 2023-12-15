package com.devweb.eventoapi.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Espaco  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false, length = 100)
    public String nome;

    @Column(nullable = false, length = 100)
    public String localizacao;

    @Column(nullable = false)
    public int capacidade;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "edicao_id")
    public Edicao edicao;
    
    @OneToMany(targetEntity = Recurso.class, cascade = CascadeType.REMOVE)
    @JoinTable(
        name="espaco_recursos",
        joinColumns = @JoinColumn(name = "espaco_id"), 
        inverseJoinColumns = @JoinColumn(name = "id"))
    public List<Recurso> recursos;


     // Getters
    public Long getId() {
      return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public Edicao getEdicao() {
        return edicao;
    }

     public Long getEdicaoId() {
        return edicao.id;
    }

    public List<Recurso> getRecursos() {
        return recursos;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public void setEdicao(Edicao edicao) {
        this.edicao = edicao;
    }

    public void setRecursos(List<Recurso> recursos) {
        this.recursos = recursos;
    }

}
