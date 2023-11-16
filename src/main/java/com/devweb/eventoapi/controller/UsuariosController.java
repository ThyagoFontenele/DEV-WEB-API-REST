package com.devweb.eventoapi.controller;

import com.devweb.eventoapi.model.Usuario;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/usuarios")
public class UsuariosController {
  
    @GetMapping
    public List<Usuario> getAll() {
        return List.of(new Usuario(1, "thyago"));
    }
    
    @GetMapping("/{id}")
    public Usuario get(@PathVariable(value = "id") int id) {
        return new Usuario(id, "thyago");
    }

    @PostMapping
    public void post(@RequestBody Usuario usuario) {

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") int id) {

    }

    @PutMapping("/{id}")
    public void put(@PathVariable(value = "id") int id, @RequestBody Usuario usuario) {

    }
}
