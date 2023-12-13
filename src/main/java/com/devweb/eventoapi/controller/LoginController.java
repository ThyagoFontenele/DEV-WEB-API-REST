package com.devweb.eventoapi.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.devweb.eventoapi.entities.Usuario;
import com.devweb.eventoapi.model.Login;
import com.devweb.eventoapi.services.UsuarioService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@ResponseBody
@RequestMapping(path = "api/v1/login")
public class LoginController {
    
    private final UsuarioService usuarioService;

    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity get(HttpServletResponse response, @RequestBody Login login) {
        Optional<Usuario> usuario = usuarioService.login(login);
        
        if (usuario.isPresent() && login.senha.equals(usuario.get().senha)) {
            Usuario user = usuario.get();
            response.addCookie(new Cookie("userId", user.id.toString()));
            ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().body("Email e/ou senha incorreto");
    }
}
