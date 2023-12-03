package com.devweb.eventoapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devweb.eventoapi.entities.Recurso;

@Repository
public interface RecursoRepository extends JpaRepository<Recurso, Long> {
    
}
