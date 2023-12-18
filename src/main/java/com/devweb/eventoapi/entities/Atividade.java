package com.devweb.eventoapi.entities;

import java.sql.Time;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Atividade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "edicao_id")
    public Edicao edicao;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setHorarioInicio(Time horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public void setHorarioFim(Time horarioFim) {
        this.horarioFim = horarioFim;
    }
    public void setEspaco(Espaco espaco) {
        this.local = espaco;
    }

    public void setEdicao(Edicao edicao) {
        this.edicao = edicao;
    }
}
