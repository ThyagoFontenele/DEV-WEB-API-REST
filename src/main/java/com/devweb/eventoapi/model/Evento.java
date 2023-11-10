package com.devweb.eventoapi.model;

import java.util.Date;

public class Evento {
    public int id;
    public String nome;
    public String descricao;
    public String sigla;
    public int ano;
    public int edicao;
    public Date dataInicial;
    public Date dataFinal;
    public String cidade;



    public Evento(
            int id,
            String nome,
            String descricao,
            String sigla,
            int ano,
            int edicao,
            Date dataInicial,
            Date dataFinal,
            String cidade) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
        this.cidade = cidade;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.edicao = edicao;
        this.sigla = sigla;
        this.descricao = descricao;
    }
}
