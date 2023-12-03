package com.devweb.eventoapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.devweb.eventoapi.entities.Evento;
import com.devweb.eventoapi.services.EventoService;

@RestController
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
    public Evento get(@PathVariable(value = "id") Long id) {
        return new Evento();
    }

    @PostMapping
    public void post(@RequestBody Evento evento) {

    }

    @PutMapping("/{id}")
    public void put(@PathVariable(value = "id") Long id, @RequestBody Evento evento) {
        
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id) {

    }
}
