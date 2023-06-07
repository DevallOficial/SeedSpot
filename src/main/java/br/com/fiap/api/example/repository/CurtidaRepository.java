package br.com.fiap.api.example.repository;

import br.com.fiap.api.example.models.Curtida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurtidaRepository extends JpaRepository<Curtida, Long> {
    Curtida findById(int busca);
}