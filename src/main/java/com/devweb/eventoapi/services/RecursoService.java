package com.devweb.eventoapi.services;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.devweb.eventoapi.entities.Recurso;
import com.devweb.eventoapi.repositories.RecursoRepository;

@Service
public class RecursoService {
    
    private final RecursoRepository recursoRepository;

    public RecursoService(RecursoRepository recursoRepository) {
        this.recursoRepository = recursoRepository;
    }

    public Optional<Recurso> getById(Long id) {
        return recursoRepository.findById(id);
    }

    public List<Recurso> getAll() {
        return recursoRepository.findAll();
    }

    public void save(Recurso entity) {
        recursoRepository.save(entity);
    }

    public void delete(Recurso entity) {
        recursoRepository.delete(entity);
    }
}
