package br.com.fiap.api.example.controller;

import br.com.fiap.api.example.config.CurtidaService;
import br.com.fiap.api.example.exceptions.RestNotFoundException;
import br.com.fiap.api.example.models.Curtida;
import br.com.fiap.api.example.repository.CurtidaRepository;
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
@RequestMapping("/api/curtidas")
public class CurtidaController {

    Logger log = LoggerFactory.getLogger(TelefoneController.class);

    @Autowired
    CurtidaRepository curtidaRepository;

    @Autowired
    CurtidaService curtidaService;

    @GetMapping()
    public List<Curtida> show(){
        return curtidaRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Curtida> show(@PathVariable Long id){
        log.info("detalhando curtida com id" + id);
        return ResponseEntity.ok(getCurtida(id));
    }

    @PostMapping()
    public ResponseEntity<Curtida> create(@RequestBody @Valid Curtida curtida, BindingResult result){
        log.info("cadastrando curtida" + curtida);
        curtidaRepository.save(curtida);
        return ResponseEntity.status(HttpStatus.CREATED).body(curtida);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Curtida> destroy(@PathVariable Long id){
        log.info("apagando curtida" + id);
        var curtida = getCurtida(id);
        curtida.setAtivo(false);
        curtidaRepository.save(curtida);
        return ResponseEntity.noContent().build();
    }



    private Curtida getCurtida(Long id) {
        var curtida = curtidaRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Curtida não encontrada"));
        return curtida;
    }



}
