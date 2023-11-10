package com.devweb.eventoapi.model;

import java.sql.Time;
import java.util.Date;

public class Atividade {
    public int id;
    public String tipo;
    public String nome;
    public Local local;
    public String descricao;
    public Date data;
    public Time horarioInicio;
    public Time horarioFim;

    public Atividade(
            int id,
            String tipo,
            String nome,
            String descricao,
            Date data,
            Time horarioInicio,
            Time horarioFim,
            Local local


    ) {
        this.id = id;
        this.tipo = tipo;
        this.nome = nome;
        this.local = local;
        this.descricao = descricao;
        this.data = data;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
    }
}
