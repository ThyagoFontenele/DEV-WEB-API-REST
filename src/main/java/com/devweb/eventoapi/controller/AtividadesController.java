package com.devweb.eventoapi.controller;

import java.util.List;

import com.devweb.eventoapi.model.Atividade;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/atividades")
public class AtividadesController {

    @GetMapping
    public List<Atividade> getAll() {
        return List.of(new Atividade(
                1,
                "atv1")
        );
    }

    @GetMapping("/{id}")
    public Atividade get(@PathVariable(value = "id") int id) {
        return new Atividade(id, "atv1");
    }
}
