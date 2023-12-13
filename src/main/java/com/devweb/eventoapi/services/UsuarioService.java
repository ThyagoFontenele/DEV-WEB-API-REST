package com.devweb.eventoapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.devweb.eventoapi.entities.Usuario;
import com.devweb.eventoapi.model.Login;
import com.devweb.eventoapi.model.ValidationResult;
import com.devweb.eventoapi.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
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

        this.usuarioRepository.save(usuario);
        return new ValidationResult();
    }

    public Optional<Usuario> login(Login login) {
        return usuarioRepository.findByEmail(login.email);
    }

    public Optional<Usuario> getById(Long id) {
        return usuarioRepository.findById(id);
    }

    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    public void save(Usuario entity) {
        usuarioRepository.save(entity);
    }

    public void delete(Usuario entity) {
        usuarioRepository.delete(entity);
    }
}
