package br.com.fiap.api.example.controller;

import br.com.fiap.api.example.config.PublicacaoService;
import br.com.fiap.api.example.exceptions.RestNotFoundException;
import br.com.fiap.api.example.models.Publicacao;
import br.com.fiap.api.example.repository.PublicacaoRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/publicacoes")
public class PublicacaoController {

    Logger log = LoggerFactory.getLogger(TelefoneController.class);

    @Autowired
    PublicacaoRepository publicacaoRepository;

    @Autowired
    PublicacaoService publicacaoService;

    @GetMapping()
    public List<Publicacao> show(){
        return publicacaoRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Publicacao> show(@PathVariable Long id){
        log.info("detalhando publicação com id" + id);
        return ResponseEntity.ok(getPublicacao(id));
    }

    @PostMapping()
    public ResponseEntity<Publicacao> create(@RequestBody @Valid Publicacao publicacao, BindingResult result){
        log.info("cadastrando publicação" + publicacao);
        publicacaoRepository.save(publicacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(publicacao);
    }

    @PutMapping("{id}")
    public ResponseEntity<Publicacao> update(@PathVariable Long id, @RequestBody @Valid Publicacao publicacao){
        log.info("atualizando publicação" + id);

        getPublicacao(id);

        publicacao.setId(id);
        publicacaoRepository.save(publicacao);

        return ResponseEntity.ok(publicacao);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Publicacao> destroy(@PathVariable Long id){
        log.info("apagando publicação" + id);
        var publicacao = getPublicacao(id);
        publicacao.setAtivo(false);
        publicacaoRepository.save(publicacao);
        return ResponseEntity.noContent().build();
    }



    private Publicacao getPublicacao(Long id) {
        var publicacao = publicacaoRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Publicação não encontrada"));
        return publicacao;
    }



}
