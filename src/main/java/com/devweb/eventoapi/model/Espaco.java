package com.devweb.eventoapi.model;


public class Espaco {
    public int id;
    public String nome;
    public String localizacao;
    public int capacidade;
    public Edicao edicao;
    public String[] recursos;

    public Espaco(
            int id,
            String nome
    ) {
        this.id = id;
        this.nome = nome;
    }
}
