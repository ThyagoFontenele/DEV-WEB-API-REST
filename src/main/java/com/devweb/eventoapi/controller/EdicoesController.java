package com.devweb.eventoapi.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.devweb.eventoapi.model.ValidationResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.devweb.eventoapi.entities.Edicao;
import com.devweb.eventoapi.entities.Usuario;
import com.devweb.eventoapi.services.EdicaoService;
import com.devweb.eventoapi.services.UsuarioService;

@RestController
@RequestMapping(path = "api/v1/edicoes")
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
    public ResponseEntity get(@PathVariable(value = "id") Long id) {

        Optional<Edicao> edicao = edicaoService.getById(id);

        if (edicao.isEmpty()){
            ResponseEntity.notFound().build();
        }

        return edicao.isPresent() ?
                ResponseEntity.ok(edicao) :
                ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity post(@CookieValue("authUserId") Long userId,
                               @RequestBody Edicao edicao) {
        if (!isUserAdmin(userId)) {
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
        }

        ValidationResult validationResult = edicaoService.saveOrUpdate(edicao);

        return validationResult.isValid()
                ? ResponseEntity.ok(edicao)
                : ResponseEntity.status(validationResult.getStatusCode()).body(validationResult.getErrorMessage());
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@CookieValue("authUserId") Long userId,
                              @PathVariable(value = "id") Long id, 
                              @RequestBody Edicao edicao) {
        if (id == null) {
            return ResponseEntity.unprocessableEntity().body("id field is required for this");
        }

        if (!isUserAdmin(userId)) {
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
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
    public ResponseEntity patch(@CookieValue("authUserId") Long userId,
                                @PathVariable(value = "id") Long id,
                                @PathVariable(value = "usuarioId") Long usuarioId) {
        if (id == null) {
            return ResponseEntity.unprocessableEntity().body("id field is required for this");
        }

        if (!isUserAdmin(userId)) {
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
        }

        Edicao edicaoPersistida = edicaoService.getById(id).orElse(null); 
        
        Optional<Usuario> organizador = getContextUser(usuarioId);

        edicaoPersistida.organizador = organizador.get();

        ValidationResult validationResult = edicaoService.saveOrUpdate(edicaoPersistida);

        return validationResult.isValid()
                ? ResponseEntity.ok(edicaoPersistida)
                : ResponseEntity.status(validationResult.getStatusCode()).body(validationResult.getErrorMessage());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@CookieValue("authUserId") Long userId,
                                 @PathVariable(value = "id") Long id) {
        if (!isUserAdmin(userId)) {
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
        }

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
