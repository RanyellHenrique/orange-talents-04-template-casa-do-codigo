package br.com.zupperacademy.ranyell.casadocodigo.utils;

import br.com.zupperacademy.ranyell.casadocodigo.autor.Autor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class NomeUniqueValidator implements ConstraintValidator<NomeUniqueValid, String> {

    @PersistenceContext
    private EntityManager manager;

    /*
    * Método responsável por verificar se o nome é unico
    * @param value
    * @param context
    */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Query query = manager.createQuery("select a from Categoria a where nome = :value");
        query.setParameter("value", value);
        List<Autor> list = query.getResultList();
        return list.isEmpty();
    }
}
