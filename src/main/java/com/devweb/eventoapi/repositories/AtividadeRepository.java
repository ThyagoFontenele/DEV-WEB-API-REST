package com.devweb.eventoapi.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devweb.eventoapi.entities.Atividade;
import com.devweb.eventoapi.entities.Espaco;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Long> {
    List<Atividade> findByLocal(Espaco espaco);    
}
