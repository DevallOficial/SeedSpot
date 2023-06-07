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
@Table(name= "T_SE_MENSAGEM")
public class Mensagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mensagem")
    private Long id;

    @NotBlank
    @Column(name = "DS_CONTEUDO_MSG")
    private String conteudo;
    @NotBlank
    @Column(name = "DT_DATA_MSG")
    private Date data;
    @NotBlank
    @Column(name = "HR_DATE_MSG")
    private LocalDateTime hora;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @JsonIgnore
    private boolean ativo = true;

}
