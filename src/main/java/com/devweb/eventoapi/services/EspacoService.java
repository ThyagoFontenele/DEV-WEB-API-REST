package com.devweb.eventoapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.devweb.eventoapi.entities.Espaco;
import com.devweb.eventoapi.repositories.EspacoRepository;

@Service
public class EspacoService {
    
    private final EspacoRepository espacoRepository;

    public EspacoService(EspacoRepository espacoRepository) {
        this.espacoRepository = espacoRepository;
    }

    public Optional<Espaco> getById(Long id) {
        return espacoRepository.findById(id);
    }

    public List<Espaco> getAll() {
        return espacoRepository.findAll();
    }

    public void save(Espaco entity) {
        espacoRepository.save(entity);
    }

    public void delete(Espaco entity) {
        espacoRepository.delete(entity);
    }
}
