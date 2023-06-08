package br.com.fiap.api.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name= "T_SE_USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Email
    @NotNull(message = "Insira um email válido")
    @Column(name = "DS_EMAIL")
    private String email;

    @NotNull(message = "Insira uma senha válida")
    @Column(name = "DS_SENHA")
    private String senha;

    @NotNull
    @Column(name = "NM_USUARIO")
    private String nome;

    @NotNull
    @Column(name = "NM_ESTADO")
    private String estado;
    @NotNull
    @Column(name = "NM_CIDADE")
    private String cidade;

    @JsonIgnore
    private boolean ativo = true;
}