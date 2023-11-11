package com.devweb.eventoapi.controller;

import java.util.List;

import com.devweb.eventoapi.model.Edicao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/edicoes")
public class EdicoesController {

    @GetMapping
    public List<Edicao> getAll() {
        return List.of(new Edicao(
                1,
                1)
        );
    }

    @GetMapping("/{id}")
    public Edicao get(@PathVariable(value = "id") int id) {
        return new Edicao(id, 1);
    }
}
