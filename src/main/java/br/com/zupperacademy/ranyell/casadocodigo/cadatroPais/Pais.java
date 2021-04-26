package br.com.zupperacademy.ranyell.casadocodigo.cadatroPais;

import br.com.zupperacademy.ranyell.casadocodigo.cadastroEstado.Estado;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "pais")
    private List<Estado> estados;

    @Column(unique = true)
    private String nome;

    @Deprecated
    public Pais() {}

    public Pais(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

    public boolean possuiEstados() {
        return !estados.isEmpty();
    }
}
