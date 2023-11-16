package com.devweb.eventoapi.model;

import java.sql.Time;
import java.util.Date;

public class Atividade {
    public int id;
    public int tipo;
    public String nome;
    public Espaco local;
    public String descricao;
    public Date data;
    public Time horarioInicio;
    public Time horarioFim;
    public Edicao edicao;

    public Atividade(
            int id,
            int tipo,
            String nome,
            String descricao,
            Date data,
            Time horarioInicio,
            Time horarioFim,
            Espaco local


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
