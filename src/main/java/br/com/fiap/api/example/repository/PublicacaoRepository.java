package br.com.fiap.api.example.repository;

import br.com.fiap.api.example.models.Publicacao;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PublicacaoRepository extends JpaRepository<Publicacao, Long> {
    Publicacao findByConteudo(String busca);

}
