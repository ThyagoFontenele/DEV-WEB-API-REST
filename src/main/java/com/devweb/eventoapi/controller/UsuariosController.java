package com.devweb.eventoapi.controller;

import com.devweb.eventoapi.entities.Atividade;
import com.devweb.eventoapi.entities.Usuario;
import com.devweb.eventoapi.model.ValidationResult;
import com.devweb.eventoapi.services.AtividadeService;
import com.devweb.eventoapi.services.UsuarioService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping(path = "api/v1/usuarios")
public class UsuariosController {

    private final UsuarioService usuarioService;
    private final AtividadeService atividadeService;

    public UsuariosController(UsuarioService usuarioService,
                              AtividadeService atividadeService) {
        this.usuarioService = usuarioService;
        this.atividadeService = atividadeService;
    }

    @GetMapping
    public List<Usuario> getAll() {
        return usuarioService.getAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable(value = "id") Long id) {
        Optional<Usuario> usuario = usuarioService.getById(id);

        return usuario.isPresent()
            ? ResponseEntity.ok(usuario.get())
            : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity post(@RequestBody Usuario usuario) {
        ValidationResult validationResult  = usuarioService.saveOrUpdate(usuario);

        return validationResult.isValid() 
            ? ResponseEntity.ok(usuario)
            : ResponseEntity.status(validationResult.getStatusCode()).body(validationResult.getErrorMessage());
    }

    @PutMapping()
    public ResponseEntity put(@RequestBody Usuario usuario) {
        if (usuario.id == null) {
            return ResponseEntity.unprocessableEntity().body("id field is required for this");
        }

        Optional<Usuario> persistedEvento = usuarioService.getById(usuario.id);

        if (!persistedEvento.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        ValidationResult validationResult = usuarioService.saveOrUpdate(usuario);

        return validationResult.isValid() 
            ? ResponseEntity.ok(usuario)
            : ResponseEntity.status(validationResult.getStatusCode()).body(validationResult.getErrorMessage());
    }
    
    @PatchMapping("/{id}/atividadesFavoritas/{atividadeId}")
    public ResponseEntity patch(@PathVariable(value = "id") Long id, @PathVariable(value = "atividadeId") Long atividadeId) {
        Optional<Usuario> usuario = usuarioService.getById(id);
        Optional<Atividade> atividade = atividadeService.getById(atividadeId);

        if (usuario.isPresent() && atividade.isPresent()) {
            usuario.get().atividadesFavoritas.add(atividade.get());
            usuarioService.save(usuario.get());
            return ResponseEntity.ok(usuario);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long id) {
        Optional<Usuario> usuario = usuarioService.getById(id);

        if (usuario.isPresent()) {
            usuarioService.delete(usuario.get());
            return ResponseEntity.ok(usuario);
        }

        return ResponseEntity.notFound().build();
    }
}
