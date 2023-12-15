package com.devweb.eventoapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.devweb.eventoapi.entities.Evento;
import com.devweb.eventoapi.model.ValidationResult;
import com.devweb.eventoapi.services.EventoService;
import com.devweb.eventoapi.services.UsuarioService;

@RestController
@ResponseBody
@RequestMapping(path = "api/v1/eventos")
public class EventosController extends AuthController {

    private final EventoService eventoService;

    public EventosController(EventoService eventoService, UsuarioService usuarioService) {
        super(usuarioService);
        this.eventoService = eventoService;
    }

    @GetMapping
    public List<Evento> getAll() {
        return eventoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable(value = "id") Long id) {
        Optional<Evento> evento = eventoService.getById(id);

        return evento.isPresent()
            ? ResponseEntity.ok(evento.get())
            : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity post(@CookieValue("authUserId") Long userId, @RequestBody Evento evento) {
        if (!isUserAdmin(userId)) {
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
        }

        ValidationResult validationResult  = eventoService.saveOrUpdate(evento);

        return validationResult.isValid() 
            ? ResponseEntity.ok(evento)
            : ResponseEntity.status(validationResult.getStatusCode()).body(validationResult.getErrorMessage());
    }

    @PutMapping
    public ResponseEntity put(@CookieValue("authUserId") Long userId, @RequestBody Evento evento) {
        if (!isUserAdmin(userId)) {
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
        }

        if (evento.id == null) {
            return ResponseEntity.unprocessableEntity().body("id field is required for this");
        }

        Optional<Evento> persistedEvento = eventoService.getById(evento.id);

        if (!persistedEvento.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        ValidationResult validationResult = eventoService.saveOrUpdate(evento);

        return validationResult.isValid() 
            ? ResponseEntity.ok(evento)
            : ResponseEntity.status(validationResult.getStatusCode()).body(validationResult.getErrorMessage());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@CookieValue("authUserId") Long userId, @PathVariable(value = "id") Long id) {
        if (!isUserAdmin(userId)) {
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
        }
        
        Optional<Evento> evento = eventoService.getById(id);

        if (evento.isPresent()) {
            eventoService.delete(evento.get());
            return ResponseEntity.ok(evento);
        }
        
        return ResponseEntity.notFound().build();
    }
}
