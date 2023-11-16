package com.devweb.eventoapi.controller;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import com.devweb.eventoapi.model.Atividade;
import com.devweb.eventoapi.model.Espaco;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/atividades")
public class AtividadesController {

    @GetMapping
    public List<Atividade> getAll() {
        return List.of(new Atividade(
                1,
                0,
                "Atividade 1",
                "primeira palestra",
                new Date(2023,12,01),
                new Time(12,30,0),
                new Time(13,0,0),
                new Espaco(1, "teatro")
                )
        );
    }

    @GetMapping("/{id}")
    public Atividade get(@PathVariable(value = "id") int id) {
        return new Atividade(
                id,
                0,
                "Atividade 1",
                "primeira palestra",
                new Date(2023,12,01),
                new Time(12,30,0),
                new Time(13,0,0),
                new Espaco(1, "teatro")
        );
    }

    @PostMapping
    public void post() {

    }

    @PutMapping
    public void put() {

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") int id){}
}
