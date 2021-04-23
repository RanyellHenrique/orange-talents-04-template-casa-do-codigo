package br.com.zupperacademy.ranyell.casadocodigo.detalheLivro;

import br.com.zupperacademy.ranyell.casadocodigo.cadastroLivro.Livro;

import java.math.BigDecimal;
import java.time.Instant;


public class DetalheLivroDTO {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer paginas;
    private String isbn;
    private Instant dataPublicacao;
    private DetalheAutorDTO autor;

    public DetalheLivroDTO(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.paginas = livro.getPaginas();
        this.isbn = livro.getIsbn();
        this.dataPublicacao = livro.getDataPublicacao();
        this.autor = new DetalheAutorDTO(livro.getAutor());
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public Instant getDataPublicacao() {
        return dataPublicacao;
    }

    public DetalheAutorDTO getAutor() {
        return autor;
    }
}
