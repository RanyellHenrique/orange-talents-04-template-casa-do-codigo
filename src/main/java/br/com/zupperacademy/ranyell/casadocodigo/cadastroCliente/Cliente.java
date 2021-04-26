package br.com.zupperacademy.ranyell.casadocodigo.cadastroCliente;

import br.com.zupperacademy.ranyell.casadocodigo.cadastroEstado.Estado;
import br.com.zupperacademy.ranyell.casadocodigo.cadatroPais.Pais;
import br.com.zupperacademy.ranyell.casadocodigo.utils.CpfCnpj;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Email
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
    private String documento;
    @NotNull
    @ManyToOne
    private Pais pais;
    @ManyToOne
    private Estado Estado;

    @Deprecated
    public Cliente() {
    }

    public Cliente( String email, String nome, String sobrenome, String endereco, String complemento,
                   String cidade, String telefone, String cep, String documento, Pais pais) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.telefone = telefone;
        this.cep = cep;
        this.documento = documento;
        this.pais = pais;
    }

    public void setEstado(Estado estado) {
        Estado = estado;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                ", documento='" + documento + '\'' +
                ", pais=" + pais +
                ", Estado=" + Estado +
                '}';
    }
}
