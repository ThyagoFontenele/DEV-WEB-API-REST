package com.devweb.eventoapi.model;

import java.util.Date;

public class Edicao {
    public int id;
    public String nome;
    public int ano;
    public Date dataInicial;
    public Date dataFinal;
    public String cidade;
    public Usuario organizador;
    public Evento evento;
    public Atividade[] atividades;

    public Edicao(
            int id,
            String nome,
            int ano,
            Date dataInicial,
            Date dataFinal,
            String cidade,
            Usuario organizador) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
        this.cidade = cidade;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.organizador = organizador;
    }
}
