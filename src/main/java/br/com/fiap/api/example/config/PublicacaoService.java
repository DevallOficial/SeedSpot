package br.com.fiap.api.example.config;
import br.com.fiap.api.example.models.Publicacao;
import br.com.fiap.api.example.repository.PublicacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PublicacaoService {

    @Autowired
    private PublicacaoRepository publicacaoRepository;

    public boolean publi(String conteudo) {
        Publicacao publicacao = publicacaoRepository.findByConteudo(conteudo) ;
        if (publicacao == null) {
            return false;
        }
        else if (publicacao.getConteudo() == conteudo){
            return true;
        }
        else{
            return false;
        }
    }
}
