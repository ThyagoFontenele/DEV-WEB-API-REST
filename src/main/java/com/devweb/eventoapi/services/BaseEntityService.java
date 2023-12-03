package com.devweb.eventoapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class BaseEntityService<T> {
    protected final JpaRepository<T, Long> repository;

    @Autowired
    public BaseEntityService(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    public T getById(Long id) {
        return repository.getReferenceById(id);
    }

    public List<T> getAll() {
        return repository.findAll();
    }    
}
