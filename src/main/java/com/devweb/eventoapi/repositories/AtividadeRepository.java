package com.devweb.eventoapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devweb.eventoapi.entities.Atividade;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Long> {
    
}
