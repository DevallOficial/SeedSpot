package br.com.fiap.api.example.repository;

import br.com.fiap.api.example.models.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
    Mensagem findByConteudo(String busca);
}