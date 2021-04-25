package br.com.zupperacademy.ranyell.casadocodigo.cadastroEstado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class CadastroEstadoController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private EstadoUnicoEmPaisValidador estadoUnicoEmPais;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(estadoUnicoEmPais);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> insert(@Valid @RequestBody CadastroEstadoDTO dto) {
        var estado = dto.toModel(manager);
        manager.persist(estado);
        return  ResponseEntity.ok().body(estado.toString());
    }
}
