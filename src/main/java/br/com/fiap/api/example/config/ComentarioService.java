package br.com.fiap.api.example.config;
import br.com.fiap.api.example.models.Comentario;
import br.com.fiap.api.example.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    public boolean comentario(String conteudo) {
        Comentario comentario = comentarioRepository.findByConteudo(conteudo) ;
        if (comentario == null) {
            return false;
        }
        else if (comentario.getConteudo() == conteudo){
            return true;
        }
        else{
            return false;
        }
    }
}
