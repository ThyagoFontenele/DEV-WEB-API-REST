package com.devweb.eventoapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devweb.eventoapi.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
