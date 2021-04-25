package br.com.zupperacademy.ranyell.casadocodigo.cadatroPais;

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
@RequestMapping("/paises")
public class CadastroPaisController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<String> insert(@Valid @RequestBody CadastroPaisDTO dto) {
        Pais pais = dto.toModel();
        manager.persist(pais);
        return ResponseEntity.ok().body(pais.toString());
    }

}
