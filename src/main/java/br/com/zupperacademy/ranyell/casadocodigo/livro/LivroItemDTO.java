package br.com.zupperacademy.ranyell.casadocodigo.livro;

public class LivroItemDTO {

    private Long id;
    private String titulo;

    public LivroItemDTO(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
