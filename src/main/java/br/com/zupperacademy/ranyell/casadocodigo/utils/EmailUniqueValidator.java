package br.com.zupperacademy.ranyell.casadocodigo.utils;

import br.com.zupperacademy.ranyell.casadocodigo.autor.Autor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class EmailUniqueValidator implements ConstraintValidator<EmailUniqueValid, String> {

    @PersistenceContext
    private EntityManager manager;
    
    /*
    * Método responsável por verificar se o email é unico
    * @param value
    * @param context
    */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Query query = manager.createQuery("select a from Autor a where email = :value");
        query.setParameter("value", value);
        List<Autor> list = query.getResultList();
        return list.isEmpty();
    }
}
