package com.devweb.eventoapi.controller;

import com.devweb.eventoapi.entities.Atividade;
import com.devweb.eventoapi.entities.Usuario;
import com.devweb.eventoapi.services.AtividadeService;
import com.devweb.eventoapi.services.UsuarioService;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/usuarios")
public class UsuariosController {

    private final UsuarioService usuarioService;

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
        usuarioService.save(usuario);
    }

    @PutMapping("/{id}")
    public void put(@PathVariable(value = "id") Long id, @RequestBody Usuario usuario) {
    }
    
    @PatchMapping("/{id}/atividadesFavoritas/{atividadeId}")
    public void patch(@PathVariable(value = "id") Long id, @PathVariable(value = "atividadeId") Long atividadeId) {
        Optional<Usuario> usuario = usuarioService.getById(id);
        Atividade atividade = new Atividade();
        atividade.id = atividadeId;

        if (usuario.isPresent()) {
            usuario.get().atividadesFavoritas.add(atividade);
            usuarioService.save(usuario.get());
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        Optional<Usuario> usuario = usuarioService.getById(id);

        if (usuario.isPresent()) {
            usuarioService.delete(usuario.get());
        }
    }
}
