package com.devweb.eventoapi.entities;

import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Usuario  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false, length = 100)
    public String nome;
    
    @Column(nullable = false, length = 100)
    public String email;

    @Column(nullable = false, length = 100)
    public String senha;
    
    @Column(nullable = false, length = 100)
    public String afiliacao;

    @Column(nullable = false)
    private boolean administrador = false;

    @ManyToMany
    @JoinTable(
        name="usuarios_atividades_favoritas",
        joinColumns = @JoinColumn(name = "usuario_id"), 
        inverseJoinColumns = @JoinColumn(name = "atividade_id"))
    public List<Atividade> atividadesFavoritas;

    public boolean isAdministrador() {
        return administrador;
    }
}
