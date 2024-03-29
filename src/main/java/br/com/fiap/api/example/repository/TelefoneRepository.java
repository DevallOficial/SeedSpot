package br.com.fiap.api.example.repository;
import br.com.fiap.api.example.models.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone, Long>{

    Telefone findByNrTelefone(int busca);

}