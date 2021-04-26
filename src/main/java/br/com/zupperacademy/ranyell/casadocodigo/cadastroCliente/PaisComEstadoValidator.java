package br.com.zupperacademy.ranyell.casadocodigo.cadastroCliente;

import br.com.zupperacademy.ranyell.casadocodigo.cadastroEstado.CadastroEstadoDTO;
import br.com.zupperacademy.ranyell.casadocodigo.cadastroEstado.Estado;
import br.com.zupperacademy.ranyell.casadocodigo.cadatroPais.Pais;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Component
public class PaisComEstadoValidator implements Validator {

    @PersistenceContext
    private EntityManager manager;

    public PaisComEstadoValidator(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return CadastroClienteDTO.class.isAssignableFrom(clazz);
    }

    /*
    * Verifica se o pais possui estado e se o estado pertence ao pais
    * */
    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) return;

        CadastroClienteDTO request = (CadastroClienteDTO) target;
        var pais = manager.find(Pais.class, request.getPaisId());
        //1
        if(pais.possuiEstados() && !request.possuiEstado())
            errors.rejectValue("estadoId", null, "O estado é obrigatório para paises com estados existentes");
        //1
        else if(request.possuiEstado()) {
            TypedQuery<Estado> query = manager.createQuery("select e from Estado e where id = :estadoId and e.pais.id = :paisId", Estado.class);
            query.setParameter("estadoId", request.getEstadoId());
            query.setParameter("paisId", request.getPaisId());
            var estados = query.getResultList();
            //1
            if(estados.isEmpty())
                errors.rejectValue("estadoId", null, "Esse estado não pertence a esse pais");
        }

    }
}