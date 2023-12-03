package com.devweb.eventoapi.controller;

import com.devweb.eventoapi.entities.Usuario;
import com.devweb.eventoapi.services.UsuarioService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/usuarios")
public class UsuariosController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuariosController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> getAll() {
        return usuarioService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Usuario> get(@PathVariable(value = "id") Long id) {
        return usuarioService.getById(id);
    }

    @PostMapping
    public void post(@RequestBody Usuario usuario) {

    }

    @PutMapping("/{id}")
    public void put(@PathVariable(value = "id") int id, @RequestBody Usuario usuario) {
        
    }
    
    @PatchMapping("/{id}/atividadesFavoritas/{atividadeId}")
    public void patch(@PathVariable(value = "id") int id, @PathVariable(value = "atividadeId") int atividadeId) {

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") int id) {

    }
}
