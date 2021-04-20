package br.com.zupperacademy.ranyell.casadocodigo.autor;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class AutorPostDTO {

    @NotBlank
    private String nome;

    @Email @NotBlank
    private String email;

    @NotBlank @Length(max = 400)
    private String descricao;

    public AutorPostDTO(@NotBlank String nome, @Email @NotBlank String email,  @NotBlank @Length(max = 400)String descricao ) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor toModel() {
        return new Autor(nome, email, descricao);
    }
}
