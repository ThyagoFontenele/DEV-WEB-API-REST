package com.devweb.eventoapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.devweb.eventoapi.entities.Espaco;
import com.devweb.eventoapi.services.EspacoService;
import com.devweb.eventoapi.services.UsuarioService;

@RestController
@RequestMapping(path = "api/v1/edicoes/{edicaoId}/espacos")
public class EspacosController extends AuthController {

    private final EspacoService espacoService;

    public EspacosController(EspacoService espacoService, UsuarioService usuarioService) {
        super(usuarioService);
        this.espacoService = espacoService;
    }

    @GetMapping
    public List<Espaco> getAll() {
        return espacoService.getAll();
    }

    @GetMapping("/{id}")
    public Espaco get(@PathVariable(value = "edicaoId") int edicaoId,
                      @PathVariable(value = "id") Long id) {
        return new Espaco();
    }

    @PostMapping
    public void post(@RequestBody Espaco espaco) {
    }

    @PutMapping("/{id}")
    public void put(@PathVariable(value = "edicaoId") int edicaoId,
                    @PathVariable(value = "id") Long id, @RequestBody Espaco espaco) {
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "edicaoId") int edicaoId,
                       @PathVariable(value = "id") Long id) {

    }
}
