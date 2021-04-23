package br.com.zupperacademy.ranyell.casadocodigo.cadastroCategoria;

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
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<String> insert(@RequestBody @Valid CategoriaPostDTO dto) {
        Categoria categoria = dto.toModel();
        manager.persist(categoria);
        return ResponseEntity.ok().body(categoria.toString());
    }
}
