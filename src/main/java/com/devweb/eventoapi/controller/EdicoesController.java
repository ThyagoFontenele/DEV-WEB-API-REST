package com.devweb.eventoapi.controller;

import java.util.List;
import com.devweb.eventoapi.model.Edicao;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/eventos/{eventoId}/edicoes")
public class EdicoesController {

    @GetMapping
    public List<Edicao> getAll() {
        return List.of(new Edicao ());
    }

    @GetMapping("/{id}")
    public Edicao get(@PathVariable(value = "eventoId") int eventoId,
                      @PathVariable(value = "id") int id) {
        return new Edicao ();
    }

    @PostMapping
    public void post(@RequestBody Edicao edicao) {

    }

    @PutMapping("/{id}")
    public void put(@PathVariable(value = "eventoId") int eventoId,
                    @PathVariable(value = "id") int id, @RequestBody Edicao edicao) {

    }

    @PatchMapping("/{id}/organizador/{usuarioId}")
    public void patch(@PathVariable(value = "eventoId") int eventoId,
                      @PathVariable(value = "id") int id,
                      @PathVariable(value = "usuarioId") int usuarioId) {

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "eventoId") int eventoId,
                       @PathVariable(value = "id") int id) {

    }
}
