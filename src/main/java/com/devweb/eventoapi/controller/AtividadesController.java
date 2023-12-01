package com.devweb.eventoapi.controller;

import java.util.List;

import com.devweb.eventoapi.model.Atividade;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/edicoes/{edicaoId}/atividades")
public class AtividadesController {

    @GetMapping
    public List<Atividade> getAll() {
        return List.of(new Atividade());
    }

    @GetMapping("/{id}")
    public Atividade get(@PathVariable(value = "edicaoId") int edicaoId,
                         @PathVariable(value = "id") int id) {
        return new Atividade();
    }

    @PostMapping
    public void post(@RequestBody Atividade atividade) {

    }

    @PutMapping("/{id}")
    public void put(@PathVariable(value = "edicaoId") int edicaoId,
                    @PathVariable(value = "id") int id,
                    @RequestBody Atividade atividade) {

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "edicaoId") int edicaoId,
                       @PathVariable(value = "id") int id) {
        
    }
}
