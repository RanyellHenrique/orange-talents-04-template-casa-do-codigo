package br.com.zupperacademy.ranyell.casadocodigo.autor;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.Instant;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @Email @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank  @Size(max = 400)
    @Column(columnDefinition = "TEXT")
    private String descricao;

    @NotNull
    private Instant instanteDeCadastro = Instant.now();


    public Autor(@NotBlank  String nome, @Email @NotBlank  String email, @NotBlank @Size(max = 400)String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    @Deprecated
    public Autor() { }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", descricao='" + descricao + '\'' +
                ", instanteDeCadastro=" + instanteDeCadastro +
                '}';
    }
}
