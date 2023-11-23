package com.devweb.eventoapi.model;

import java.util.List;

public class Usuario {
    public int id;
    public String nome;
    public String email;
    public String senha;
    public String afiliacao;
    public List<Atividade> atividadesFavoritas;
    private boolean administrador;
    
    public boolean isAdministrador() {
        return administrador;
    }

    public Usuario(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.administrador = false;
    }
}
