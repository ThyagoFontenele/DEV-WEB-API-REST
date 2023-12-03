package com.devweb.eventoapi.services;

import org.springframework.stereotype.Service;

import com.devweb.eventoapi.entities.Evento;
import com.devweb.eventoapi.repositories.EventoRepository;

@Service
public class EventoService extends BaseEntityService<Evento> {
    
    public EventoService(EventoRepository eventoRepository) {
        super(eventoRepository);
    }
}
