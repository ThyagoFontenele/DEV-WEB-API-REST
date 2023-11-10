package com.devweb.eventoapi.controller;

import java.util.Date;
import java.util.List;
import com.devweb.eventoapi.model.Evento;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/eventos")
public class EventosController {

    @GetMapping
    public List<Evento> getEventos() {
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
    public Evento getEvento(@PathVariable(value = "id") int id) {
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
}
