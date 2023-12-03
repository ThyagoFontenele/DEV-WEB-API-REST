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
import jakarta.persistence.OneToMany;

@Entity
public class Evento  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(nullable = false, length = 100)
    public String nome;
    @Column(nullable = false, length = 200)
    public String descricao;
    @Column(nullable = false, length = 20)
    public String sigla;
    @OneToMany(targetEntity = Edicao.class, cascade = CascadeType.REMOVE)
    @JoinTable(
        name="edicao",
        joinColumns = @JoinColumn(name = "evento_id"), 
        inverseJoinColumns = @JoinColumn(name = "id"))
    public List<Edicao> edicoes;
}
