package com.devweb.eventoapi.controller;

import java.util.Optional;

import com.devweb.eventoapi.entities.Usuario;
import com.devweb.eventoapi.services.UsuarioService;

public class AuthController {
    
    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public boolean isUserAdmin(Long id) {
        Optional<Usuario> usuario = getContextUser(id);

        return usuario.isPresent() && usuario.get().isAdministrador();
    }

    public Optional<Usuario> getContextUser(Long id) {
        return usuarioService.getById(id);
    }
}
