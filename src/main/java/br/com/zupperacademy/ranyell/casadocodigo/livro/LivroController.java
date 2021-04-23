package br.com.zupperacademy.ranyell.casadocodigo.livro;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/livros")
public class LivroController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<String> insert(@Valid @RequestBody LivroPostDTO dto) {
        Livro livro = dto.toModel(manager);
        manager.persist(livro);
        return ResponseEntity.ok().body(livro.toString());
    }

    @GetMapping
    public ResponseEntity<List<LivroItemDTO>> findAll() {
        TypedQuery<LivroItemDTO> query = manager.createQuery("select new br.com.zupperacademy.ranyell.casadocodigo." +
                "livro.LivroItemDTO(l.id, l.titulo) from Livro l", LivroItemDTO.class);
        List<LivroItemDTO> livros = query.getResultList();
        return ResponseEntity.ok().body(livros);
    }
}
