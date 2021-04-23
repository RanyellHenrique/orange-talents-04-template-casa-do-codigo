package br.com.zupperacademy.ranyell.casadocodigo.detalheLivro;

import br.com.zupperacademy.ranyell.casadocodigo.cadastroAutor.Autor;

public class DetalheAutorDTO {

    private String nome;
    private String descricao;

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public DetalheAutorDTO(Autor autor) {
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
    }
}
