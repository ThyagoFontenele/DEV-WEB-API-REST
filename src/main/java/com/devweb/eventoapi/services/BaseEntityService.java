package com.devweb.eventoapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BaseEntityService<T> {
    protected final JpaRepository<T, Long> repository;

    public BaseEntityService(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    public Optional<T> getById(Long id) {
        return repository.findById(id);
    }

    public List<T> getAll() {
        return repository.findAll();
    }

    public void save(T entity) {
        repository.save(entity);
    }

    public void delete(T entity) {
        repository.delete(entity);
    }
}
