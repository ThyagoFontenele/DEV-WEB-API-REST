package com.devweb.eventoapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.devweb.eventoapi.entities.Evento;
import com.devweb.eventoapi.model.ValidationResult;
import com.devweb.eventoapi.repositories.EventoRepository;

@Service
public class EventoService {
    
    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public ValidationResult saveOrUpdate(Evento evento) {
        if (evento.descricao == null) {
            return new ValidationResult("descricao field is required");
        } else if (evento.nome == null) {
            return new ValidationResult("nome field is required");
        } else if (evento.sigla == null) {
            return new ValidationResult("sigla field is required");
        }

        eventoRepository.save(evento);
        return new ValidationResult();
    }

    public Optional<Evento> getById(Long id) {
        return eventoRepository.findById(id);
    }

    public List<Evento> getAll() {
        return eventoRepository.findAll();
    }

    public void save(Evento entity) {
        eventoRepository.save(entity);
    }

    public void delete(Evento entity) {
        eventoRepository.delete(entity);
    }
}
