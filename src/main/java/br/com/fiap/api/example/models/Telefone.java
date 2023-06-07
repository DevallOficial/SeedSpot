package br.com.fiap.api.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name= "T_SE_TELEFONE")
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_telefone")
    private Long id;

    @NotBlank(message = "EX: 55")
    @Column(name = "NR_DDD")
    private int numeroDDD;

    @NotBlank(message = "EX: 11")
    @Column(name = "NR_DDI")
    private int numeroDDI;

    @NotBlank(message = "EX: 999999999")
    @Column(name = "NR_TELEFONE")
    private int nrTelefone;
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @JsonIgnore
    private boolean ativo = true;

}
