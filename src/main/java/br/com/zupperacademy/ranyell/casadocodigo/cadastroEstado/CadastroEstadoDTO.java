package br.com.zupperacademy.ranyell.casadocodigo.cadastroEstado;

import br.com.zupperacademy.ranyell.casadocodigo.cadatroPais.Pais;
import br.com.zupperacademy.ranyell.casadocodigo.utils.ExistValue;
import br.com.zupperacademy.ranyell.casadocodigo.utils.UniqueValue;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CadastroEstadoDTO {

    @NotBlank
    private String nome;
    @NotNull
    @ExistValue(classDomain = Pais.class, fieldName = "id")
    private Long paisId;

    public CadastroEstadoDTO(String nome, Long paisId) {
        this.nome = nome;
        this.paisId = paisId;
    }

    public Estado toModel(EntityManager manager){
        return new Estado(nome, manager.find(Pais.class, paisId));
    }

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }
}
