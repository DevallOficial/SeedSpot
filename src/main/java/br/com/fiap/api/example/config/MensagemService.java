package br.com.fiap.api.example.config;
import br.com.fiap.api.example.models.Comentario;
import br.com.fiap.api.example.models.Mensagem;
import br.com.fiap.api.example.repository.ComentarioRepository;
import br.com.fiap.api.example.repository.MensagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MensagemService {

    @Autowired
    private MensagemRepository mensagemRepository;

    public boolean mensagem(String conteudo) {
        Mensagem mensagem = mensagemRepository.findByConteudo(conteudo) ;
        if (mensagem == null) {
            return false;
        }
        else if (mensagem.getConteudo() == conteudo){
            return true;
        }
        else{
            return false;
        }
    }
}
