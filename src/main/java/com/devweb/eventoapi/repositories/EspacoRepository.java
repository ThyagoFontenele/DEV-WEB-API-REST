package com.devweb.eventoapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devweb.eventoapi.entities.Espaco;

@Repository
public interface EspacoRepository extends JpaRepository<Espaco, Long> {

}
