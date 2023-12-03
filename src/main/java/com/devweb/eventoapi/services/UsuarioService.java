package com.devweb.eventoapi.services;

import org.springframework.stereotype.Service;

import com.devweb.eventoapi.entities.Usuario;
import com.devweb.eventoapi.repositories.UsuarioRepository;

@Service
public class UsuarioService extends BaseEntityService<Usuario> {
    
    public UsuarioService(UsuarioRepository usuarioRepository) {
        super(usuarioRepository);
    }
}
