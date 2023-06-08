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
@Table(name= "T_SE_LIKE")
public class Curtida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curtida")
    private Long id;
    @NotNull
    @Column(name = "DT_DATA_CURTIDA")
    private Date data;
    @NotNull
    @JsonFormat(pattern = "HH:mm:ss")
    @Column(name = "HR_HORA_CURTIDA")
    private LocalTime hora;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_publicacao")
    private Publicacao publicacao;
    @JsonIgnore
    private boolean ativo = true;
}
