package com.devweb.eventoapi.controller;

import com.devweb.eventoapi.model.Cliente;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/clientes")
public class ClientesController {
  
    @GetMapping
    public List<Cliente> getClientes() {
        return List.of(new Cliente("thyago", 1));
    }
    
    @GetMapping("/{id}")
    public Cliente getCliente(@PathVariable(value = "id") int id) {
        return new Cliente("thyago", id);
    }
}
