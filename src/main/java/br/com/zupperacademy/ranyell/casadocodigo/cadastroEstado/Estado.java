package br.com.zupperacademy.ranyell.casadocodigo.cadastroEstado;

import br.com.zupperacademy.ranyell.casadocodigo.cadatroPais.Pais;

import javax.persistence.*;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToOne
    private Pais pais;

    @Deprecated
    public Estado() {
    }

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", pais=" + pais +
                '}';
    }

    public boolean pertenceAPais(Pais pais) {
        return  this.pais.equals(pais);
    }
}
