package com.devweb.eventoapi.model;

import java.util.Date;

public class EdicaoDeEvento {
    public int id;
    public String nome;
    public String descricao;
    public String sigla;
    public int ano;
    public int edicao;
    public Date dataInicial;
    public Date dataFinal;
    public String cidade;
    public Organizador organizador;

    public EdicaoDeEvento(
            int id,
            String nome,
            String descricao,
            String sigla,
            int ano,
            int edicao,
            Date dataInicial,
            Date dataFinal,
            String cidade,
            Organizador organizador) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
        this.cidade = cidade;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.edicao = edicao;
        this.sigla = sigla;
        this.descricao = descricao;
        this.organizador = organizador;
    }
}
