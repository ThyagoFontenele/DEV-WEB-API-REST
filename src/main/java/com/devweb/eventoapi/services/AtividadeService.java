package com.devweb.eventoapi.services;

import java.util.List;
import java.util.Optional;

import com.devweb.eventoapi.entities.Usuario;
import com.devweb.eventoapi.model.ValidationResult;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.devweb.eventoapi.entities.Atividade;
import com.devweb.eventoapi.repositories.AtividadeRepository;

@Service
public class AtividadeService {

    private final AtividadeRepository atividadeRepository;

    public AtividadeService(AtividadeRepository atividadeRepository) {
       this.atividadeRepository = atividadeRepository;
    }

    public ValidationResult saveOrUpdate(Atividade atividade) {
        if (atividade.nome == null) {
            return new ValidationResult("nome field is required");
        } else if (atividade.data == null) {
            return new ValidationResult("data field is required");
        } else if (atividade.descricao == null) {
            return new ValidationResult("descricao field is required");
        } else if (atividade.horarioInicio == null) {
            return new ValidationResult("horarioInicio field is required");
        } else if (atividade.horarioFim == null) {
            return new ValidationResult("horarioFim field is required");
        } else if (atividade.local == null) {
            return new ValidationResult("local field is required");
        }

        this.atividadeRepository.save(atividade);
        return new ValidationResult();
    }

    public Optional<Atividade> getById(Long id) {
        return atividadeRepository.findById(id);
    }

    public List<Atividade> getAll() {
        return atividadeRepository.findAll();
    }

    public void save(Atividade entity) {
        atividadeRepository.save(entity);
    }

    public void delete(Atividade entity) {
        atividadeRepository.delete(entity);
    }
}
