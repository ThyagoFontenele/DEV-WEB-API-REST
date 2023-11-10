package com.devweb.eventoapi.controller;

import com.devweb.eventoapi.model.Usuario;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/clientes")
public class UsuariosController {
  
    @GetMapping
    public List<Usuario> getUsuarios() {
        return List.of(new Usuario("thyago", 1));
    }
    
    @GetMapping("/{id}")
    public Usuario getUsuario(@PathVariable(value = "id") int id) {
        return new Usuario("thyago", id);
    }
}
