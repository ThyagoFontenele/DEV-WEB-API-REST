package com.devweb.eventoapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Recursos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    @Column(nullable = false, length = 100)
    public String descricao;
    @ManyToOne
    @JoinColumn(name = "espacoId")
    public Espaco espaco;
}
