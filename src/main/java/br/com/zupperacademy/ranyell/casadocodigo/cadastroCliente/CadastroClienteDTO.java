package br.com.zupperacademy.ranyell.casadocodigo.cadastroCliente;

import br.com.zupperacademy.ranyell.casadocodigo.cadastroEstado.Estado;
import br.com.zupperacademy.ranyell.casadocodigo.cadatroPais.Pais;
import br.com.zupperacademy.ranyell.casadocodigo.utils.CpfCnpj;
import br.com.zupperacademy.ranyell.casadocodigo.utils.ExistValue;
import br.com.zupperacademy.ranyell.casadocodigo.utils.UniqueValue;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class CadastroClienteDTO {


    @NotBlank  @Email
    @UniqueValue(classDomain = Cliente.class, fieldName = "email")
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;
    @NotBlank @CpfCnpj
    @UniqueValue(classDomain = Cliente.class, fieldName = "documento")
    private String documento;
    @NotNull
    @ExistValue(classDomain = Pais.class, fieldName = "id")
    private Long paisId;
    private Long estadoId;

    public CadastroClienteDTO(String email, String nome, String sobrenome, String endereco, String complemento,
                              String cidade, String telefone, String cep, String documento, Long paisId) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.telefone = telefone;
        this.cep = cep;
        this.documento = documento;
        this.paisId = paisId;
    }

    public Cliente toModel(EntityManager manager) {
        Pais pais = manager.find(Pais.class, paisId);
        Cliente cliente = new Cliente(email, nome,  sobrenome,  endereco,  complemento,
                cidade,  telefone,  cep,  documento,  pais);
        if(estadoId != null) {
            Estado estado = manager.find(Estado.class, estadoId);
            cliente.setEstado(estado);
        }
        return cliente;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public boolean possuiEstado() {
        return Optional.ofNullable(estadoId).isPresent();
    }
}
