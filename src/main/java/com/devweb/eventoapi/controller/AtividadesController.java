package com.devweb.eventoapi.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.devweb.eventoapi.entities.Atividade;
import com.devweb.eventoapi.entities.Edicao;
import com.devweb.eventoapi.model.ValidationResult;
import com.devweb.eventoapi.services.UsuarioService;
import com.devweb.eventoapi.services.AtividadeService;
import com.devweb.eventoapi.services.EdicaoService;

@RestController
@RequestMapping(path = "api/v1/edicoes/{edicaoId}/atividades")
public class AtividadesController extends AuthController {

    private final AtividadeService atividadeService;
    private final EdicaoService edicaoService;

    public AtividadesController(EdicaoService edicaoService,
                                AtividadeService atividadeService,
                                UsuarioService usuarioService) {
        super(usuarioService);
        this.edicaoService = edicaoService;
        this.atividadeService = atividadeService;
    }

    @GetMapping
    public List<Atividade> getAll(@PathVariable(value = "edicaoId") Long edicaoId) {
        List<Atividade> list = atividadeService.getAll();
        List<Atividade> filteredList = new java.util.ArrayList<>(List.of());
        list.forEach(atividade -> {
            if (Objects.equals(atividade.edicao.id, edicaoId)) {
                filteredList.add(atividade);
            }
        });

        return filteredList;
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable(value = "edicaoId") Long edicaoId,
                              @PathVariable(value = "id") Long id) {

        Optional<Atividade> atividade = atividadeService.getById(id);

        if (atividade.isEmpty()){
            ResponseEntity.notFound().build();
        }

        if(atividade.isPresent() && !Objects.equals(atividade.get().edicao.id, edicaoId)){
            ResponseEntity.notFound().build();
        }

        return atividade.isPresent() 
            ?   ResponseEntity.ok(atividade.get()) 
            : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity post(@PathVariable(value = "edicaoId") Long edicaoId, 
                               @CookieValue("authUserId") Long userId, 
                               @RequestBody Atividade atividade) {
    
        Optional<Edicao> edicao = edicaoService.getById(edicaoId);

        if (!edicao.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        if (!edicao.get().organizador.id.equals(userId)) {
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
        }

        ValidationResult validationResult  = atividadeService.saveOrUpdate(atividade);

        return validationResult.isValid()
            ? ResponseEntity.ok(atividade)
            : ResponseEntity.status(validationResult.getStatusCode()).body(validationResult.getErrorMessage());
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@CookieValue("authUserId") Long userId,
                              @PathVariable(value = "edicaoId") Long edicaoId,
                              @PathVariable(value = "id") Long id,
                              @RequestBody Atividade atividade) {

        if (id == null) {
            return ResponseEntity.unprocessableEntity().body("id field is required for this");
        }

        if (!Objects.equals(atividade.id, id)) {
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
        }

        Optional<Atividade> atividadePersistida = atividadeService.getById(atividade.id);

        if (!atividadePersistida.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        if (!atividadePersistida.get().edicao.organizador.id.equals(userId)) {
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
        }

        ValidationResult validationResult = atividadeService.saveOrUpdate(atividade);

        return validationResult.isValid()
            ? ResponseEntity.ok(atividade)
            : ResponseEntity.status(validationResult.getStatusCode()).body(validationResult.getErrorMessage());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@CookieValue("authUserId") Long userId,
                                 @PathVariable(value = "edicaoId") Long edicaoId,
                                 @PathVariable(value = "id") Long id) {
        Optional<Atividade> atividade = atividadeService.getById(id);

        if (!atividade.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        if (!atividade.get().edicao.organizador.id.equals(userId)) {
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
        }

        if (!Objects.equals(atividade.get().id, id)) {
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
        }

        atividadeService.delete(atividade.get());
        return ResponseEntity.ok(atividade);
    }
}
