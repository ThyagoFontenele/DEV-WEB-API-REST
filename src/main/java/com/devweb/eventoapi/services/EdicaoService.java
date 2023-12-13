package com.devweb.eventoapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.devweb.eventoapi.entities.Edicao;
import com.devweb.eventoapi.repositories.EdicaoRepository;

@Service
public class EdicaoService {
    
    private final EdicaoRepository edicaoRepository;

    public EdicaoService(EdicaoRepository edicaoRepository) {
        this.edicaoRepository = edicaoRepository;
    }

    public Optional<Edicao> getById(Long id) {
        return edicaoRepository.findById(id);
    }

    public List<Edicao> getAll() {
        return edicaoRepository.findAll();
    }

    public void save(Edicao entity) {
        edicaoRepository.save(entity);
    }

    public void delete(Edicao entity) {
        edicaoRepository.delete(entity);
    }
}
