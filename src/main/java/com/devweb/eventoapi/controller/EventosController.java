package com.devweb.eventoapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.devweb.eventoapi.entities.Evento;
import com.devweb.eventoapi.model.ValidationResult;
import com.devweb.eventoapi.services.EventoService;

@RestController
@ResponseBody
@RequestMapping(path = "api/v1/eventos")
public class EventosController {

    private final EventoService eventoService;

    public EventosController(EventoService eventoService) {
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
    public ResponseEntity post(@RequestBody Evento evento) {
        ValidationResult validationResult  = eventoService.saveOrUpdate(evento);

        return validationResult.isValid() 
            ? ResponseEntity.ok(evento)
            : ResponseEntity.status(validationResult.getStatusCode()).body(validationResult.getErrorMessage());
    }

    @PutMapping
    public ResponseEntity put(@RequestBody Evento evento) {
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
    public ResponseEntity delete(@PathVariable(value = "id") Long id) {
        Optional<Evento> evento = eventoService.getById(id);

        if (evento.isPresent()) {
            eventoService.delete(evento.get());
            return ResponseEntity.ok(evento);
        }
        
        return ResponseEntity.notFound().build();
    }
}
