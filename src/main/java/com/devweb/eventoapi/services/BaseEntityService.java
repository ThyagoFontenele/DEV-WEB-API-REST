package com.devweb.eventoapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class BaseEntityService<T> {
    protected final JpaRepository<T, Long> repository;

    @Autowired
    public BaseEntityService(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    public Optional<T> getById(Long id) {
        return repository.findById(id);
    }

    public List<T> getAll() {
        return repository.findAll();
    }    
}
