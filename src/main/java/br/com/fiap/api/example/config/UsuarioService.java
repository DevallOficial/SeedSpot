package br.com.fiap.api.example.config;

import br.com.fiap.api.example.models.Usuario;
import br.com.fiap.api.example.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;


    public Usuario adicionarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public boolean login(String email, String password) {
        Usuario usuario = usuarioRepository.findByEmail(email) ;
        if (usuario == null) {
            return false;
        }
        else if (usuario.getSenha() == password){
            return true;
        }
        else{
            return false;
        }
    }
}
