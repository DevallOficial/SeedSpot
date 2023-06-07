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
@Table(name= "T_SE_POST")
public class Publicacao {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_publicacao")
    private Long id;

    @NotBlank
    @Column(name = "DS_CONTEUDO_PUB")
    private String conteudo;

    @Column(name = "NM_ANEXO")
    private byte anexo;
    @NotBlank
    @Column(name = "DT_DATA_PUB")
    private Date data;
    @NotBlank
    @Column(name = "HR_HORA_PUB")
    private LocalDateTime hora;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @JsonIgnore
    private boolean ativo = true;
}
