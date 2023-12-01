package com.devweb.eventoapi.model;

import java.util.Date;
import java.util.List;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    @Column(nullable = false)
    public String nome;
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
    @Column(nullable = false)
    public Usuario organizador;
    @ManyToOne
    @JoinColumn(name = "eventoId")
    public Evento evento;
    @OneToMany(targetEntity = Atividade.class, cascade = CascadeType.REMOVE)
    @JoinTable(
        name="Atividade",
        joinColumns = @JoinColumn(name = "edicaoId"), 
        inverseJoinColumns = @JoinColumn(name = "id"))
    public List<Atividade> atividades;
    @OneToMany(targetEntity = Espaco.class, cascade = CascadeType.REMOVE)
    @JoinTable(
        name="Espaco",
        joinColumns = @JoinColumn(name = "edicaoId"), 
        inverseJoinColumns = @JoinColumn(name = "id"))
    public List<Espaco> espacos;
}
