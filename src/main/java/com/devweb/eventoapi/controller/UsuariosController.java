package com.devweb.eventoapi.controller;

import com.devweb.eventoapi.model.Usuario;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/usuarios")
public class UsuariosController {
  
    @GetMapping
    public List<Usuario> getAll() {
        return List.of(new Usuario("thyago", 1));
    }
    
    @GetMapping("/{id}")
    public Usuario get(@PathVariable(value = "id") int id) {
        return new Usuario("thyago", id);
    }

    @PostMapping
    public void post() {

    }
}
