package com.devweb.eventoapi.controller;

import java.util.List;

import com.devweb.eventoapi.model.Administrador;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/administradores")
public class AdministradoresController {

    @GetMapping
    public List<Administrador> getAll() {
        return List.of(new Administrador(
                1,
                "Adm1")
        );
    }

    @GetMapping("/{id}")
    public Administrador get(@PathVariable(value = "id") int id) {
        return new Administrador(id, "adm1");
    }

    @PostMapping
    public void post() {

    }

    @DeleteMapping
    public void delete() {

    }

    @PutMapping
    public void put() {

    }
}
