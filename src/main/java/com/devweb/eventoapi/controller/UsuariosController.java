package com.devweb.eventoapi.controller;

import com.devweb.eventoapi.entities.Atividade;
import com.devweb.eventoapi.entities.Usuario;
import com.devweb.eventoapi.model.ValidationResult;
import com.devweb.eventoapi.services.AtividadeService;
import com.devweb.eventoapi.services.UsuarioService;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping(path = "api/v1/usuarios")
public class UsuariosController extends AuthController {

    private final UsuarioService usuarioService;
    private final AtividadeService atividadeService;

    public UsuariosController(UsuarioService usuarioService,
                              AtividadeService atividadeService) {
        super(usuarioService);
        this.usuarioService = usuarioService;
        this.atividadeService = atividadeService;
    }

    @GetMapping
    public ResponseEntity getAll(@CookieValue("authUserId") Long contextUserId) {
        if (!isUserAdmin(contextUserId)) {
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
        }

        return ResponseEntity.ok(usuarioService.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity get(@CookieValue("authUserId") Long contextUserId, @PathVariable(value = "id") Long id) {
        if (!isUserAdmin(contextUserId)) {
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
        }

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
    public ResponseEntity put(@CookieValue("authUserId") Long contextUserId, @RequestBody Usuario usuario) {
        if (usuario.id == null) {
            return ResponseEntity.unprocessableEntity().body("id field is required for this");
        }

        if (contextUserId != usuario.id) {
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
        }

        Optional<Usuario> usuarioPersistido = usuarioService.getById(usuario.id);

        if (!usuarioPersistido.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        ValidationResult validationResult = usuarioService.saveOrUpdate(usuario);

        return validationResult.isValid() 
            ? ResponseEntity.ok(usuario)
            : ResponseEntity.status(validationResult.getStatusCode()).body(validationResult.getErrorMessage());
    }
    
    @PatchMapping("/{id}/atividadesFavoritas/{atividadeId}")
    public ResponseEntity patch(@CookieValue("authUserId") Long contextUserId, 
                                @PathVariable(value = "id") Long id, 
                                @PathVariable(value = "atividadeId") Long atividadeId) {
        Optional<Usuario> usuario = usuarioService.getById(id);
        Optional<Atividade> atividade = atividadeService.getById(atividadeId);

        if (!usuario.isPresent() || !atividade.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        if (contextUserId != id) {
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
        }
        
        usuario.get().atividadesFavoritas.add(atividade.get());
        usuarioService.save(usuario.get());
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@CookieValue("authUserId") Long contextUserId, @PathVariable(value = "id") Long id) {
        Optional<Usuario> usuario = usuarioService.getById(id);

        if (!usuario.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        if (contextUserId != id) {
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
        }

       usuarioService.delete(usuario.get());
       return ResponseEntity.ok(usuario); 
    }
}
