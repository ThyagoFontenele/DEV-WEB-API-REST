package com.devweb.eventoapi.controller;

import java.util.List;

import com.devweb.eventoapi.model.Espaco;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/edicoes/{edicaoId}/espacos")
public class EspacosController {

    @GetMapping
    public List<Espaco> getAll() {
        return List.of(new Espaco(
                1,
                "Anfiteatro")
        );
    }

    @GetMapping("/{id}")
    public Espaco get(@PathVariable(value = "edicaoId") int edicaoId,
                      @PathVariable(value = "id") int id) {
        return new Espaco(id, "Anfiteatro");
    }

    @PostMapping
    public void post(@RequestBody Espaco espaco) {
    }

    @PutMapping("/{id}")
    public void put(@PathVariable(value = "edicaoId") int edicaoId,
                    @PathVariable(value = "id") int id, @RequestBody Espaco espaco) {
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "edicaoId") int edicaoId,
                       @PathVariable(value = "id") int id) {

    }
}
