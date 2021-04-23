package br.com.zupperacademy.ranyell.casadocodigo.detalheLivro;

import br.com.zupperacademy.ranyell.casadocodigo.cadastroLivro.Livro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class DetalheLivroController {

    @PersistenceContext
    private EntityManager manager;


    @GetMapping(value = "/{id}")
    public ResponseEntity<DetalheLivroDTO> findById(@PathVariable Long id) {
        //1
        Livro livro = manager.find(Livro.class, id);
        if(livro == null)
            return ResponseEntity.notFound().build();
        //1
        return ResponseEntity.ok().body(new DetalheLivroDTO(livro));
    }
}
