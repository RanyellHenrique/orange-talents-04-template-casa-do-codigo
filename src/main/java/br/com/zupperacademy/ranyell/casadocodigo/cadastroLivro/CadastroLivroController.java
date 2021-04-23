package br.com.zupperacademy.ranyell.casadocodigo.cadastroLivro;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;



@RestController
@RequestMapping("/livros")
public class CadastroLivroController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<String> insert(@Valid @RequestBody CadastroLivroDTO dto) {
        var livro = dto.toModel(manager);
        manager.persist(livro);
        return ResponseEntity.ok().body(livro.toString());
    }

}
