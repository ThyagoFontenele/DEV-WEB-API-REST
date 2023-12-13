package com.devweb.eventoapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.devweb.eventoapi.entities.Atividade;
import com.devweb.eventoapi.repositories.AtividadeRepository;

@Service
public class AtividadeService {

    private final AtividadeRepository atividadeRepository;

    public AtividadeService(AtividadeRepository atividadeRepository) {
       this.atividadeRepository = atividadeRepository;
    }

    public Optional<Atividade> getById(Long id) {
        return atividadeRepository.findById(id);
    }

    public List<Atividade> getAll() {
        return atividadeRepository.findAll();
    }

    public void save(Atividade entity) {
        atividadeRepository.save(entity);
    }

    public void delete(Atividade entity) {
        atividadeRepository.delete(entity);
    }
}
