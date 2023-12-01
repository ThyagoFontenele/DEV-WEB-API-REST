package com.devweb.eventoapi.controller;

import com.devweb.eventoapi.model.Usuario;
import com.devweb.eventoapi.repositories.UsuarioRepository;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/usuarios")
public class UsuariosController {

    @GetMapping
    public List<Usuario> getAll() {
        return List.of(new Usuario());
    }
    
    @GetMapping("/{id}")
    public Usuario get(@PathVariable(value = "id") int id) {
        return new Usuario();
    }

    @PostMapping
    public void post(@RequestBody Usuario usuario) {

    }

    @PutMapping("/{id}")
    public void put(@PathVariable(value = "id") int id, @RequestBody Usuario usuario) {
        
    }
    
    @PatchMapping("/{id}/atividadeFavorita/{atividadeId}")
    public void patch(@PathVariable(value = "id") int id, @PathVariable(value = "atividadeId") int atividadeId) {

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") int id) {

    }
}
