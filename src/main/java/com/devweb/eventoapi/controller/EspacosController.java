package com.devweb.eventoapi.controller;

import java.util.List;
import com.devweb.eventoapi.services.EdicaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.devweb.eventoapi.DTO.EspacosDTO;
import com.devweb.eventoapi.entities.Edicao;
import com.devweb.eventoapi.entities.Espaco;
import com.devweb.eventoapi.entities.Usuario;
import com.devweb.eventoapi.model.ValidationResult;
import com.devweb.eventoapi.services.EspacoService;
import com.devweb.eventoapi.services.UsuarioService;
import java.util.Optional;


import jakarta.persistence.EntityNotFoundException;
@RestController
@RequestMapping(path = "api/v1/espacos")
public class EspacosController extends AuthController {

    private final EspacoService espacoService;
    private final EdicaoService edicaoService;

    public EspacosController(EdicaoService edicaoService,EspacoService espacoService, UsuarioService usuarioService) {
        super(usuarioService);
        this.espacoService = espacoService;
        this.edicaoService = edicaoService;
    }

    @GetMapping("/edicao/{edicaoId}")
      public List<Espaco> getAllWithEdicaoId(@PathVariable(value = "edicaoId") Long edicaoId) {
      return espacoService.getAll(edicaoId);
  }

    @GetMapping
    public List<Espaco> getAll() {
        return espacoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable(value = "id") Long id) {
    try {
        Espaco espaco = espacoService.getById(id)
            .orElseThrow(() -> new EntityNotFoundException("Espaço não encontrado"));
        return ResponseEntity.ok(espaco);
    } catch (EntityNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}

    @PostMapping
    public ResponseEntity post(@RequestBody EspacosDTO espacoDTO) {
      Espaco espaco = new Espaco();
      espaco.setNome(espacoDTO.getNome());
      espaco.setLocalizacao(espacoDTO.getLocalizacao());
      espaco.setCapacidade(espacoDTO.getCapacidade());

      
      if (espacoDTO.getEdicaoId() != null) {
        Optional<Edicao> edicaoOptional = edicaoService.getById(espacoDTO.getEdicaoId());
    
        if (edicaoOptional.isPresent()) {
            Edicao edicao = edicaoOptional.get();
            espaco.setEdicao(edicao);
        } else {
          return ResponseEntity
          .status(HttpStatus.NOT_FOUND)
          .body("Edição com ID " + espacoDTO.getEdicaoId() + " não encontrada");
        }
      }
        ValidationResult validationResult  = espacoService.saveOrUpdate(espaco);

        return validationResult.isValid() 
            ? ResponseEntity.ok(espaco)
            : ResponseEntity.status(validationResult.getStatusCode()).body(validationResult.getErrorMessage());
    }

    @PutMapping("/{id}")
    public void put(@PathVariable(value = "edicaoId") Long edicaoId,
                    @PathVariable(value = "id") Long id, @RequestBody Espaco espaco) {
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "edicaoId") Long edicaoId,
                       @PathVariable(value = "id") Long id) {

    }
}
