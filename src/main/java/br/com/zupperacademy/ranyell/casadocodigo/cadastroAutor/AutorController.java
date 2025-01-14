package br.com.zupperacademy.ranyell.casadocodigo.cadastroAutor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<String> insert(@Valid @RequestBody AutorPostDTO dto) {
        Autor autor = dto.toModel();
        manager.persist(autor);
        return ResponseEntity.ok().body(autor.toString());
    }
}
