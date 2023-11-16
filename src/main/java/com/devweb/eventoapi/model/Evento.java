package com.devweb.eventoapi.model;

public class Evento {
    public int id;
    public String nome;
    public String descricao;
    public String sigla;
    public Edicao[] edicoes;

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
