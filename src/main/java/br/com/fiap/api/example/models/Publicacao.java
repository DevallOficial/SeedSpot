package br.com.fiap.api.example.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;
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

    @NotNull
    @Column(name = "DS_CONTEUDO_PUB")
    private String conteudo;

    @Column(name = "NM_ANEXO")
    private byte anexo;
    @NotNull
    @Column(name = "DT_DATA_PUB")
    private Date data;
    @NotNull
    @JsonFormat(pattern = "HH:mm:ss")
    @Column(name = "HR_HORA_PUB")
    private LocalTime hora;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @JsonIgnore
    private boolean ativo = true;
}
