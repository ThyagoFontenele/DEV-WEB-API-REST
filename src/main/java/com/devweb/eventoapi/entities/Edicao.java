package com.devweb.eventoapi.entities;

import java.util.Date;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Edicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    public int ano;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    public Date dataInicial;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    public Date dataFinal;

    @Column(nullable = false, length = 100)
    public String cidade;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    public Usuario organizador;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "evento_id")
    public Evento evento;

    @JsonIgnore
    @OneToMany(targetEntity = Atividade.class, cascade = CascadeType.REMOVE)
    @JoinTable(
        name="atividade",
        joinColumns = @JoinColumn(name = "edicao_id"), 
        inverseJoinColumns = @JoinColumn(name = "id"))
    public List<Atividade> atividades;

    @JsonIgnore
    @OneToMany(targetEntity = Espaco.class, cascade = CascadeType.REMOVE)
    @JoinTable(
        name="espaco",
        joinColumns = @JoinColumn(name = "edicao_id"), 
        inverseJoinColumns = @JoinColumn(name = "id"))
    public List<Espaco> espacos;


    public Long getEdicaoId() {
      return this.id;
  }

    // Getters
    public Long getId() {
        return id;
    }

    public int getAno() {
        return ano;
    }

    public Date getDatainicial() {
        return dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public String getCidade() {
        return cidade;
    }

    public Usuario getOrganizador() {
        return organizador;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public List<Espaco> getEspacos() {
        return espacos;
    }

    public Evento get() {
        return evento;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

    public void setEspacos(List<Espaco> espacos) {
        this.espacos = espacos;
    }
}