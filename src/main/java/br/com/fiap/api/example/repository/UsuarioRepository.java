package br.com.fiap.api.example.repository;
import br.com.fiap.api.example.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    Usuario findByEmail(String busca);
    Usuario save(Usuario usuario);


}
