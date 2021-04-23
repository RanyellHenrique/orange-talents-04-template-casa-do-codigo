package br.com.zupperacademy.ranyell.casadocodigo.livro;

import br.com.zupperacademy.ranyell.casadocodigo.autor.Autor;
import br.com.zupperacademy.ranyell.casadocodigo.categoria.Categoria;
import br.com.zupperacademy.ranyell.casadocodigo.utils.UniqueValue;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    @NotBlank
    private  String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    @NotBlank
    private String sumario;
    @NotNull
    @DecimalMin("20.0")
    private BigDecimal preco;
    @NotNull
    @Min(100)
    private Integer paginas;
    @Column(unique = true)
    @NotBlank
    private String isbn;
    @NotNull
    @Future
    private Instant dataPublicacao;

    @NotNull
    @ManyToOne
    private Categoria categoria;

    @NotNull
    @ManyToOne
    private Autor autor;

    @Deprecated
    public Livro() {}

    public Livro(String titulo, String resumo, String sumario, BigDecimal preco, Integer paginas, String isbn, Instant dataPublicacao, Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", preco=" + preco +
                ", paginas=" + paginas +
                ", isbn='" + isbn + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                ", categoria=" + categoria +
                ", autor=" + autor +
                '}';
    }
}
