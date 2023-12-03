package com.devweb.eventoapi.entities;

import java.sql.Time;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Atividade implements Entidade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    @Column(nullable = false)
    public int tipo;
    @Column(nullable = false, length = 100)
    public String nome;
    @Column(nullable = false, length = 100)
    public String descricao;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    public Date data;
    @Temporal(TemporalType.TIME)
    @Column(nullable = false)
    public Time horarioInicio;
    @Temporal(TemporalType.TIME)
    public Time horarioFim;
    @ManyToOne
    @JoinColumn(name = "espaco_id")
    public Espaco local;
    @ManyToOne
    @JoinColumn(name = "edicao_id")
    public Edicao edicao;
}
