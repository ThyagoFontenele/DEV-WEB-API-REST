package com.devweb.eventoapi.controller;

import java.util.Date;
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
                "NEV",
                2023,
                1,
                new Date(2023,12,1),
                new Date(2023,12,10),
                "Rio de Janeiro"
                )
        );
    }

    @GetMapping("/{id}")
    public Evento get(@PathVariable(value = "id") int id) {
        return new Evento(
                id,
                "Meu evento",
                "novo evento legal",
                "NEV",
                2023,
                1,
                new Date(2023,12,1),
                new Date(2023,12,10),
                "Rio de Janeiro"
        );
    }

    @PostMapping
    public void post() {

    }

    @DeleteMapping
    public void delete() {

    }
}
