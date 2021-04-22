package br.com.zupperacademy.ranyell.casadocodigo.categoria;

import br.com.zupperacademy.ranyell.casadocodigo.utils.NomeUniqueValid;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class CategoriaPostDTO {

    @NotBlank
    @NomeUniqueValid(message = "Nome já existente")
    private String nome;

    public CategoriaPostDTO(@JsonProperty("nome") @NotBlank String nome) {
        this.nome = nome;
    }

    public Categoria toModel() {
        return new Categoria(nome);
    }
}
