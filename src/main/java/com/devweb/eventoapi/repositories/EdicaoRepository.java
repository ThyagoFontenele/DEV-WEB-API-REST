package com.devweb.eventoapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devweb.eventoapi.entities.Edicao;

@Repository
public interface EdicaoRepository extends JpaRepository<Edicao, Long> {
    
}
