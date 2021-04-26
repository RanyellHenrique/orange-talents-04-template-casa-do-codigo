package br.com.zupperacademy.ranyell.casadocodigo.cadastroCliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class CadastroClienteController {

    @PersistenceContext
    private EntityManager maganer;

    @Autowired
    private PaisComEstadoValidator paisComEstadoValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(paisComEstadoValidator);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> insert(@Valid @RequestBody CadastroClienteDTO dto) {
        Cliente cliente = dto.toModel(maganer);
        maganer.persist(cliente);
        return ResponseEntity.ok().body(cliente.toString());
    }
}
