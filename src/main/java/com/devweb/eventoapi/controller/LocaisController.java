package com.devweb.eventoapi.controller;

import java.util.List;

import com.devweb.eventoapi.model.Local;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/locais")
public class LocaisController {

    @GetMapping
    public List<Local> getAll() {
        return List.of(new Local(
                1,
                "Anfiteatro")
        );
    }

    @GetMapping("/{id}")
    public Local get(@PathVariable(value = "id") int id) {
        return new Local(id, "Anfiteatro");
    }

    @PostMapping
    public void post() {
    }

    @PutMapping
    public void put() {
    }

    @DeleteMapping
    public void delete() {
    }
}
