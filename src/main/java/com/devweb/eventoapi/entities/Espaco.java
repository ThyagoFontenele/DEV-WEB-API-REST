package com.devweb.eventoapi.entities;

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

@Entity
public class Espaco implements Entidade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    @Column(nullable = false, length = 100)
    public String nome;
    @Column(nullable = false, length = 100)
    public String localizacao;
    @Column(nullable = false)
    public int capacidade;
    @ManyToOne
    @JoinColumn(name = "edicao_id")
    public Edicao edicao;
    @OneToMany(targetEntity = Recurso.class, cascade = CascadeType.REMOVE)
    @JoinTable(
        name="espaco_recursos",
        joinColumns = @JoinColumn(name = "espaco_id"), 
        inverseJoinColumns = @JoinColumn(name = "id"))
    public List<Recurso> recursos;
}
