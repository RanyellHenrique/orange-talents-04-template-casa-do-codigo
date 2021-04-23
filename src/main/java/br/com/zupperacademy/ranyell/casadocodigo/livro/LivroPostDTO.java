package br.com.zupperacademy.ranyell.casadocodigo.livro;

import br.com.zupperacademy.ranyell.casadocodigo.autor.Autor;
import br.com.zupperacademy.ranyell.casadocodigo.categoria.Categoria;
import br.com.zupperacademy.ranyell.casadocodigo.utils.ExistValue;
import br.com.zupperacademy.ranyell.casadocodigo.utils.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.Instant;

public class LivroPostDTO {

    @NotBlank
    @UniqueValue(fieldName = "titulo", classDomain = Livro.class)
    private String titulo;
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
    @UniqueValue(fieldName = "isbn", classDomain = Livro.class)
    private String isbn;
    @Future
    @NotNull
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ", timezone = JsonFormat.DEFAULT_TIMEZONE)
    private Instant dataPublicacao;
    @NotNull
    @ExistValue(classDomain = Autor.class, fieldName = "id")
    private Long autorId;
    @NotNull
    @ExistValue(classDomain = Categoria.class, fieldName = "id")
    private Long categoriaId;

    public LivroPostDTO(String titulo, String resumo, String sumario, BigDecimal preco, Integer paginas, String isbn,
                        Instant dataPublicacao, Long autorId, Long categoriaId) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.autorId = autorId;
        this.categoriaId = categoriaId;
    }

    public Livro toModel(EntityManager manager) {
        @NotNull Autor autor = manager.find(Autor.class, autorId);
        @NotNull Categoria categoria = manager.find(Categoria.class, categoriaId);
        return new Livro(titulo, resumo, sumario, preco, paginas, isbn, dataPublicacao,  categoria, autor);
    }
}
