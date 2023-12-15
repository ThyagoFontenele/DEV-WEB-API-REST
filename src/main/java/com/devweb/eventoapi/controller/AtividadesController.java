package com.devweb.eventoapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.devweb.eventoapi.entities.Atividade;
import com.devweb.eventoapi.services.AtividadeService;
import com.devweb.eventoapi.services.UsuarioService;

@RestController
@RequestMapping(path = "api/v1/edicoes/{edicaoId}/atividades")
public class AtividadesController extends AuthController {

    private final AtividadeService atividadeService;

    public AtividadesController(AtividadeService atividadeService, UsuarioService usuarioService) {
        super(usuarioService);
        this.atividadeService = atividadeService;
    }

    @GetMapping
    public List<Atividade> getAll(@PathVariable(value = "edicaoId") Long edicaoId) {
        return atividadeService.getAll();
    }

    @GetMapping("/{id}")
    public Atividade get(@PathVariable(value = "edicaoId") Long edicaoId,
                         @PathVariable(value = "id") Long id) {
        return new Atividade();
    }

    @PostMapping
    public void post(@RequestBody Atividade atividade) {

    }

    @PutMapping("/{id}")
    public void put(@PathVariable(value = "edicaoId") Long edicaoId,
                    @PathVariable(value = "id") Long id,
                    @RequestBody Atividade atividade) {

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "edicaoId") Long edicaoId,
                       @PathVariable(value = "id") Long id) {
        
    }
}
