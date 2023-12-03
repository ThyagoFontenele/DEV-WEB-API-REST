package com.devweb.eventoapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devweb.eventoapi.entities.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
    
}
