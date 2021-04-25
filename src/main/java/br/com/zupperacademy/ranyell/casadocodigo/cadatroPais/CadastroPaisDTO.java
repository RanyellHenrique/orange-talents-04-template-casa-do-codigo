package br.com.zupperacademy.ranyell.casadocodigo.cadatroPais;

import br.com.zupperacademy.ranyell.casadocodigo.utils.UniqueValue;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class CadastroPaisDTO {

    @UniqueValue(fieldName = "nome", classDomain = Pais.class)
    @NotBlank
    private String nome;

    public CadastroPaisDTO(@JsonProperty("nome") String nome) {
        this.nome = nome;
    }

    public Pais toModel() {
        return new Pais(nome);
    }
}
