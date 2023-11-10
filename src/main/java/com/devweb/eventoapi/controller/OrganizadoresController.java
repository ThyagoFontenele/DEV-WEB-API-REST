package com.devweb.eventoapi.controller;

import java.util.List;
import com.devweb.eventoapi.model.Organizador;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/organizadores")
public class OrganizadoresController {

    @GetMapping
    public List<Organizador> getAll() {
        return List.of(new Organizador(
                        1,
                        "Org1")
        );
    }

    @GetMapping("/{id}")
    public Organizador get(@PathVariable(value = "id") int id) {
        return new Organizador(id, "org1");
    }

    @PostMapping
    public void post() {

    }

    @PutMapping
    public void put() {

    }
}
