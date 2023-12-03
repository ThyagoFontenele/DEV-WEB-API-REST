package com.devweb.eventoapi.services;

import org.springframework.stereotype.Service;

import com.devweb.eventoapi.entities.Edicao;
import com.devweb.eventoapi.repositories.EdicaoRepository;

@Service
public class EdicaoService extends BaseEntityService<Edicao> {
    
    public EdicaoService(EdicaoRepository edicaoRepository) {
        super(edicaoRepository);
    }
}
