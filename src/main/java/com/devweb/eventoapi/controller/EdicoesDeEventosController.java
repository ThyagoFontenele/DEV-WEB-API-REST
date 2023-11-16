package com.devweb.eventoapi.controller;

import java.util.Date;
import java.util.List;
import com.devweb.eventoapi.model.Edicao;
import com.devweb.eventoapi.model.Usuario;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/edicoes")
public class EdicoesDeEventosController {

    @GetMapping
    public List<Edicao> getAll() {
        return List.of(new Edicao(
                1,
                "Meu evento",
                2023,
                new Date(2023,12,1),
                new Date(2023,12,10),
                "Rio de Janeiro",
                new Usuario(1, "name")
                )
        );
    }

    @GetMapping("/{id}")
    public Edicao get(@PathVariable(value = "id") int id) {
        return new Edicao(
                id,
                "Meu evento",
                2023,
                new Date(2023,12,1),
                new Date(2023,12,10),
                "Rio de Janeiro",
                new Usuario(1, "name"));
    }

    @PostMapping
    public void post() {

    }
    @PutMapping
    public void put() {

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") int id) {

    }
}
