package com.devweb.eventoapi.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.devweb.eventoapi.entities.Atividade;
import com.devweb.eventoapi.entities.Espaco;
import com.devweb.eventoapi.model.ValidationResult;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.devweb.eventoapi.entities.Edicao;
import com.devweb.eventoapi.services.EdicaoService;
import com.devweb.eventoapi.services.UsuarioService;

@RestController
@RequestMapping(path = "api/v1/eventos/{eventoId}/edicoes")
public class EdicoesController extends AuthController {

    private final EdicaoService edicaoService;

    public EdicoesController(EdicaoService edicaoService, UsuarioService usuarioService) {
        super(usuarioService);
        this.edicaoService = edicaoService;
    }

    @GetMapping
    public List<Edicao> getAll() {
        return edicaoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable(value = "eventoId") int eventoId,
                      @PathVariable(value = "id") Long id) {

        Optional<Edicao> edicao = edicaoService.getById(id);

        if (edicao.isEmpty()){
            ResponseEntity.notFound().build();
        }

        return edicao.isPresent() ?
                ResponseEntity.ok(edicao) :
                ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity post(@RequestBody Edicao edicao) {
        {
            ValidationResult validationResult  = edicaoService.saveOrUpdate(edicao);

            return validationResult.isValid()
                    ? ResponseEntity.ok(edicao)
                    : ResponseEntity.status(validationResult.getStatusCode()).body(validationResult.getErrorMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable(value = "eventoId") int eventoId,
                    @PathVariable(value = "id") Long id, @RequestBody Edicao edicao) {

        if (id == null) {
            return ResponseEntity.unprocessableEntity().body("id field is required for this");
        }

        Edicao edicaoPersistida = edicaoService.getById(id).orElse(null);

        if (edicaoPersistida == null) {
            return ResponseEntity.notFound().build();
        }

        edicaoPersistida.setAno(edicao.ano);
        edicaoPersistida.setAtividades(edicao.atividades);
        edicaoPersistida.setEspacos(edicao.espacos);
        edicaoPersistida.setDataInicial(edicao.dataInicial);
        edicaoPersistida.setDataFinal(edicao.dataFinal);
        edicaoPersistida.setCidade(edicao.cidade);

        ValidationResult validationResult = edicaoService.saveOrUpdate(edicaoPersistida);

        return validationResult.isValid()
                ? ResponseEntity.ok(edicao)
                : ResponseEntity.status(validationResult.getStatusCode()).body(validationResult.getErrorMessage());
    }

    @PatchMapping("/{id}/organizador/{usuarioId}")
    public void patch(@PathVariable(value = "eventoId") int eventoId,
                      @PathVariable(value = "id") Long id,
                      @PathVariable(value = "usuarioId") int usuarioId) {

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "eventoId") int eventoId,
                       @PathVariable(value = "id") Long id) {
        Optional<Edicao> edicao = edicaoService.getById(id);

        if (edicao.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        if (!Objects.equals(edicao.get().id, id)) {
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
        }

        edicaoService.delete(edicao.get());
        return ResponseEntity.ok(edicao);
    }
}
