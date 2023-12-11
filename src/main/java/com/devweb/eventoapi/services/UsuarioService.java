package com.devweb.eventoapi.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.devweb.eventoapi.entities.Usuario;
import com.devweb.eventoapi.model.ValidationResult;
import com.devweb.eventoapi.repositories.UsuarioRepository;

@Service
public class UsuarioService extends BaseEntityService<Usuario> {
    
    public UsuarioService(UsuarioRepository usuarioRepository) {
        super(usuarioRepository);
    }

    public ValidationResult saveOrUpdate(Usuario usuario) {
        if (usuario.nome == null) {
            return new ValidationResult("nome field is required");
        } else if (usuario.senha == null) {
            return new ValidationResult("senha field is required");
        } else if (usuario.email == null) {
            return new ValidationResult("email field is required");
        } else if (usuario.afiliacao == null) {
            return new ValidationResult("afiliacao field is required");
        } else if (usuario.isAdministrador()) {
            return new ValidationResult("u dont have permission for administrador true", HttpStatus.METHOD_NOT_ALLOWED);
        }

        this.repository.save(usuario);
        return new ValidationResult();
    }
}
