package br.com.fiap.api.example.controller;

import br.com.fiap.api.example.config.MensagemService;
import br.com.fiap.api.example.exceptions.RestNotFoundException;
import br.com.fiap.api.example.models.Mensagem;
import br.com.fiap.api.example.repository.MensagemRepository;
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
@RequestMapping("/api/mensagens")
public class MensagemController {

    Logger log = LoggerFactory.getLogger(TelefoneController.class);

    @Autowired
    MensagemRepository mensagemRepository;

    @Autowired
    MensagemService mensagemService;

    @GetMapping()
    public List<Mensagem> show(){
        return mensagemRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Mensagem> show(@PathVariable Long id){
        log.info("detalhando mensagem com id" + id);
        return ResponseEntity.ok(getMensagem(id));
    }

    @PostMapping()
    public ResponseEntity<Mensagem> create(@RequestBody @Valid Mensagem mensagem, BindingResult result){
        log.info("cadastrando mensagem" + mensagem);
        mensagemRepository.save(mensagem);
        return ResponseEntity.status(HttpStatus.CREATED).body(mensagem);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Mensagem> destroy(@PathVariable Long id){
        log.info("apagando mensagem" + id);
        var mensagem = getMensagem(id);
        mensagem.setAtivo(false);
        mensagemRepository.save(mensagem);
        return ResponseEntity.noContent().build();
    }



    private Mensagem getMensagem(Long id) {
        var mensagem = mensagemRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Mensagem não encontrada"));
        return mensagem;
    }



}
