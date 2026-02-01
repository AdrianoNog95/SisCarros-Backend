package app.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import app.entity.Usuario;
import app.repository.UsuarioRepository;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario login(String username, String password) {

        Usuario usuario = usuarioRepository
            .findByUsername(username)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!usuario.getPassword().equals(password)) {
            throw new RuntimeException("Senha inválida");
        }

        return usuario;
    }
    
}    



