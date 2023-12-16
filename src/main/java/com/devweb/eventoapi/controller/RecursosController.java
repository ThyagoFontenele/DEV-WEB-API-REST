package com.devweb.eventoapi.controller;

import java.util.List;
import com.devweb.eventoapi.services.EdicaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.devweb.eventoapi.DTO.EspacosDTO;
import com.devweb.eventoapi.DTO.RecursosDTO;
import com.devweb.eventoapi.entities.Edicao;
import com.devweb.eventoapi.entities.Espaco;
import com.devweb.eventoapi.entities.Recurso;
import com.devweb.eventoapi.entities.Usuario;
import com.devweb.eventoapi.model.ValidationResult;
import com.devweb.eventoapi.services.EspacoService;
import com.devweb.eventoapi.services.RecursoService;
import com.devweb.eventoapi.services.UsuarioService;
import java.util.Optional;


import jakarta.persistence.EntityNotFoundException;
@RestController
@RequestMapping(path = "api/v1/espacos/{espacoId}/recursos")
public class RecursosController extends AuthController {

    private final EspacoService espacoService;
    private final RecursoService recursoService;

    public RecursosController(RecursoService recursoService,EspacoService espacoService, UsuarioService usuarioService) {
        super(usuarioService);
        this.espacoService = espacoService;
        this.recursoService = recursoService;
    }

    @PostMapping
    public ResponseEntity post(@RequestBody RecursosDTO recursoDTO, @PathVariable(value = "espacoId") Long espacoId) {
      Recurso recurso = new Recurso();
      recurso.setDescricao(recursoDTO.getDescricao());
      
      if (espacoId != null) {
        Optional<Espaco> espacoOptional = espacoService.getById(espacoId);
    
        if (espacoOptional.isPresent()) {
            Espaco espaco = espacoOptional.get();
            recurso.setEspaco(espaco);
        } else {
          return ResponseEntity
          .status(HttpStatus.NOT_FOUND)
          .body("Edição com ID " + espacoId + " não encontrada");
        }
      }
        recursoService.save(recurso);
        return ResponseEntity.ok(recurso);
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@RequestBody RecursosDTO recursoDTO, @PathVariable(value = "id") Long id) {
      Recurso recurso = recursoService.getById(id).orElseThrow(() -> new EntityNotFoundException("Recurso não encontrado"));
      recurso.setDescricao(recursoDTO.getDescricao());
      recursoService.save(recurso);
      return ResponseEntity.ok(recurso);
    }

     @DeleteMapping("/{id}")
    public ResponseEntity delete(@RequestBody RecursosDTO recursoDTO, @PathVariable(value = "id") Long id) {
      Recurso recurso = recursoService.getById(id).orElseThrow(() -> new EntityNotFoundException("Recurso não encontrado"));
      recursoService.delete(recurso);
      return ResponseEntity.ok("Recurso deletado com sucesso");
    }
}
