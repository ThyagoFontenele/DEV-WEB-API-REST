package com.devweb.eventoapi.services;

import org.springframework.stereotype.Service;

import com.devweb.eventoapi.entities.Evento;
import com.devweb.eventoapi.model.ValidationResult;
import com.devweb.eventoapi.repositories.EventoRepository;

@Service
public class EventoService extends BaseEntityService<Evento> {
    
    public EventoService(EventoRepository eventoRepository) {
        super(eventoRepository);
    }

    public ValidationResult saveOrUpdate(Evento evento) {
        if (evento.descricao == null) {
            return new ValidationResult("descricao field is required");
        } else if (evento.nome == null) {
            return new ValidationResult("nome field is required");
        } else if (evento.sigla == null) {
            return new ValidationResult("sigla field is required");
        }

        this.repository.save(evento);
        return new ValidationResult();
    }
}
