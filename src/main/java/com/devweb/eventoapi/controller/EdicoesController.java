package com.devweb.eventoapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.devweb.eventoapi.entities.Edicao;
import com.devweb.eventoapi.services.EdicaoService;

@RestController
@RequestMapping(path = "api/v1/eventos/{eventoId}/edicoes")
public class EdicoesController {

    private final EdicaoService edicaoService;

    public EdicoesController(EdicaoService edicaoService) {
        this.edicaoService = edicaoService;
    }

    @GetMapping
    public List<Edicao> getAll() {
        return edicaoService.getAll();
    }

    @GetMapping("/{id}")
    public Edicao get(@PathVariable(value = "eventoId") int eventoId,
                      @PathVariable(value = "id") Long id) {
        return new Edicao ();
    }

    @PostMapping
    public void post(@RequestBody Edicao edicao) {

    }

    @PutMapping("/{id}")
    public void put(@PathVariable(value = "eventoId") int eventoId,
                    @PathVariable(value = "id") Long id, @RequestBody Edicao edicao) {

    }

    @PatchMapping("/{id}/organizador/{usuarioId}")
    public void patch(@PathVariable(value = "eventoId") int eventoId,
                      @PathVariable(value = "id") Long id,
                      @PathVariable(value = "usuarioId") int usuarioId) {

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "eventoId") int eventoId,
                       @PathVariable(value = "id") Long id) {

    }
}
