package com.devweb.eventoapi.controller;

import java.util.List;
import com.devweb.eventoapi.model.Evento;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/eventos")
public class EventosController {

    @GetMapping
    public List<Evento> getAll() {
        return List.of(new Evento(
                1,
                "Meu evento",
                "novo evento legal",
                "NEV"
                )
        );
    }

    @GetMapping("/{id}")
    public Evento get(@PathVariable(value = "id") int id) {
        return new Evento(
                id,
                "Meu evento",
                "novo evento legal",
                "NEV"
        );
    }

    @PostMapping
    public void post(@RequestBody Evento evento) {

    }

    @PutMapping("/{id}")
    public void put(@PathVariable(value = "id") int id, @RequestBody Evento evento) {
        
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") int id) {

    }
}
