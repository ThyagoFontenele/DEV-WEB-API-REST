package com.devweb.eventoapi.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.devweb.eventoapi.services.EdicaoService;
import com.devweb.eventoapi.entities.Espaco;
import com.devweb.eventoapi.entities.Usuario;
import com.devweb.eventoapi.model.ValidationResult;
import com.devweb.eventoapi.repositories.EspacoRepository;

@Service
public class EspacoService {
    
    private final EspacoRepository espacoRepository;

    public EspacoService(EspacoRepository espacoRepository) {
        this.espacoRepository = espacoRepository;
    }

    public ValidationResult saveOrUpdate(Espaco espaco) {
        if (espaco.nome == null) {
            return new ValidationResult("nome field is required");
        } else if (espaco.localizacao == null) {
            return new ValidationResult("localizacao field is required");
        } else if (espaco.capacidade < 0) {
            return new ValidationResult("capacidade field should be a positive number");
        } else if (espaco.localizacao == null) {
            return new ValidationResult("localizacao field is required");
        } else if (espaco.edicao == null) {
            return new ValidationResult("edicao field is required");
        } 
        this.espacoRepository.save(espaco);
        return new ValidationResult();
    }


    public Optional<Espaco> getById(Long id) {
        return espacoRepository.findById(id);
    }

    public List<Espaco> getAll() {
      return espacoRepository.findAll();
  }
  
  public List<Espaco> getAll(Long edicaoId) {
      List<Espaco> espacos = getAll(); 
      return espacos.stream()
                .filter(espaco -> espaco.getEdicao() != null && espaco.getEdicao().getEdicaoId().equals(edicaoId))
                .collect(Collectors.toList());
  }

    public void save(Espaco entity) {
        espacoRepository.save(entity);
    }

    public void delete(Espaco entity) {
        espacoRepository.delete(entity);
    }
}
