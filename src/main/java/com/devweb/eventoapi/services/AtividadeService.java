package com.devweb.eventoapi.services;

import org.springframework.stereotype.Service;

import com.devweb.eventoapi.entities.Atividade;
import com.devweb.eventoapi.repositories.AtividadeRepository;

@Service
public class AtividadeService extends BaseEntityService<Atividade> {

    public AtividadeService(AtividadeRepository atividadeRepository) {
       super(atividadeRepository);
    }
}
