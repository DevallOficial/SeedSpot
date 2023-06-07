package br.com.fiap.api.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name= "T_SE_COMENT")
public class Comentario {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comentario")
    private Long id;
    @NotBlank
    @Column(name = "DS_CONTEUDO_COM")
    private String conteudo;
    @NotBlank
    @Column(name = "DT_DATA_COM")
    private Date data;
    @NotBlank
    @Column(name = "HR_DATE_COM")
    private LocalDateTime hora;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_publicacao")
    private Publicacao publicacao;
    @JsonIgnore
    private boolean ativo = true;
}
