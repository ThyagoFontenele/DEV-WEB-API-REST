package com.devweb.eventoapi.model;

public class Usuario {
    public int id;
    public String nome;
    public String email;
    public String login;
    public String afiliacao;
    public Atividade[] atividadesFavoritas;
    private boolean isAdmin;
    
    public boolean isAdmin() {
        return isAdmin;
    }

    public Usuario(int id, String nome)  {
        this.id = id;
        this.nome = nome;
        this.isAdmin = false;
    }
}
