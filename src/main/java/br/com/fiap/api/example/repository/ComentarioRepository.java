package br.com.fiap.api.example.repository;

import br.com.fiap.api.example.models.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    Comentario findByConteudo(String busca);
}
