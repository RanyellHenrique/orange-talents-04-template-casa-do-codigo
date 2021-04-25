package br.com.zupperacademy.ranyell.casadocodigo.cadastroEstado;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Component
public class EstadoUnicoEmPaisValidador implements Validator {

    private EntityManager manager;

    public EstadoUnicoEmPaisValidador(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return CadastroEstadoDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) return;

        CadastroEstadoDTO request = (CadastroEstadoDTO) target;
        TypedQuery<Estado> query = manager.createQuery("select e from Estado e where e.nome = :nome and e.pais.id = :paisId", Estado.class);
        query.setParameter("nome", request.getNome());
        query.setParameter("paisId", request.getPaisId());
        var estado = query.getResultList();
        if(!estado.isEmpty()) {
            errors.rejectValue("nome", null, "Este país já possui esse estado");
        }
    }
}
