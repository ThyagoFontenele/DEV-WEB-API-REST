package com.devweb.eventoapi.model;

import java.util.List;

public class Evento {
    public int id;
    public String nome;
    public String descricao;
    public String sigla;
    public List<Edicao> edicoes;

    public Evento(
            int id,
            String nome,
            String descricao,
            String sigla
            ) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.descricao = descricao;
    }
}
