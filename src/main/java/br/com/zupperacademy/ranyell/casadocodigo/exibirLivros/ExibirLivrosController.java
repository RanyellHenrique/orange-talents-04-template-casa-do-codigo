package br.com.zupperacademy.ranyell.casadocodigo.exibirLivros;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class ExibirLivrosController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping
    public ResponseEntity<List<LivroItemDTO>> findAll() {
        TypedQuery<LivroItemDTO> query = manager.createQuery("select new br.com.zupperacademy.ranyell.casadocodigo." +
                "exibirLivros.LivroItemDTO(l.id, l.titulo) from Livro l", LivroItemDTO.class);
        List<LivroItemDTO> livros = query.getResultList();
        return ResponseEntity.ok().body(livros);
    }
}
