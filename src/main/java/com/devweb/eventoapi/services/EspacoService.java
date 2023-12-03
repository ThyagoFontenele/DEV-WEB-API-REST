package com.devweb.eventoapi.services;

import org.springframework.stereotype.Service;

import com.devweb.eventoapi.entities.Espaco;
import com.devweb.eventoapi.repositories.EspacoRepository;

@Service
public class EspacoService extends BaseEntityService<Espaco> {
    
    public EspacoService(EspacoRepository espacoRepository) {
        super(espacoRepository);
    }
}
