package com.devweb.eventoapi.controller;

import java.util.Date;
import java.util.List;
import com.devweb.eventoapi.model.EdicaoDeEvento;
import com.devweb.eventoapi.model.Organizador;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/edicoes")
public class EdicoesDeEventosController {

    @GetMapping
    public List<EdicaoDeEvento> getAll() {
        return List.of(new EdicaoDeEvento(
                1,
                "Meu evento",
                "novo evento legal",
                "NEV",
                2023,
                1,
                new Date(2023,12,1),
                new Date(2023,12,10),
                "Rio de Janeiro",
                new Organizador(1, "name")
                )
        );
    }

    @GetMapping("/{id}")
    public EdicaoDeEvento get(@PathVariable(value = "id") int id) {
        return new EdicaoDeEvento(id,
                "Meu evento",
                "novo evento legal",
                "NEV",
                2023,
                1,
                new Date(2023,12,1),
                new Date(2023,12,10),
                "Rio de Janeiro",
                new Organizador(1, "name")
        );
    }

    @PostMapping
    public void post() {

    }
    @PutMapping
    public void put() {

    }

    @DeleteMapping
    public void delete(){}
}
