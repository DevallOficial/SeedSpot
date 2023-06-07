package br.com.fiap.api.example.controller;

import br.com.fiap.api.example.config.ComentarioService;
import br.com.fiap.api.example.exceptions.RestNotFoundException;
import br.com.fiap.api.example.models.Comentario;
import br.com.fiap.api.example.repository.ComentarioRepository;
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
@RequestMapping("/api/comentarios")
public class ComentarioController {

    Logger log = LoggerFactory.getLogger(TelefoneController.class);

    @Autowired
    ComentarioRepository comentarioRepository;

    @Autowired
    ComentarioService comentarioService;

    @GetMapping()
    public List<Comentario> show(){
        return comentarioRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Comentario> show(@PathVariable Long id){
        log.info("detalhando comentário com id" + id);
        return ResponseEntity.ok(getComentario(id));
    }

    @PostMapping()
    public ResponseEntity<Comentario> create(@RequestBody @Valid Comentario comentario, BindingResult result){
        log.info("cadastrando comentário" + comentario);
        comentarioRepository.save(comentario);
        return ResponseEntity.status(HttpStatus.CREATED).body(comentario);
    }

    @PutMapping("{id}")
    public ResponseEntity<Comentario> update(@PathVariable Long id, @RequestBody @Valid Comentario comentario){
        log.info("atualizando comentário" + id);

        getComentario(id);

        comentario.setId(id);
        comentarioRepository.save(comentario);

        return ResponseEntity.ok(comentario);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Comentario> destroy(@PathVariable Long id){
        log.info("apagando comentário" + id);
        var comentario = getComentario(id);
        comentario.setAtivo(false);
        comentarioRepository.save(comentario);
        return ResponseEntity.noContent().build();
    }



    private Comentario getComentario(Long id) {
        var comentario = comentarioRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Comentário não encontrada"));
        return comentario;
    }



}
