package com.devweb.eventoapi.services;

import com.devweb.eventoapi.entities.Recurso;
import com.devweb.eventoapi.repositories.RecursoRepository;

public class RecursoService extends BaseEntityService<Recurso> {
    
    public RecursoService(RecursoRepository recursoRepository) {
        super(recursoRepository);
    }
}
