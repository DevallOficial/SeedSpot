package br.com.fiap.api.example.config;
import br.com.fiap.api.example.models.Curtida;
import br.com.fiap.api.example.repository.CurtidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CurtidaService {

    @Autowired
    private CurtidaRepository curtidaRepository;

    public boolean curtida(int Id) {
        Curtida curtida = curtidaRepository.findById(Id) ;
        if (curtida == null) {
            return false;
        }
        else if (curtida.getId() == Id){
            return true;
        }
        else{
            return false;
        }
    }
}
