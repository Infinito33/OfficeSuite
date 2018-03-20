package th.database.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import th.database.dao.IDao;

/**
 * Abstract dao implementation which creates session factory and provide basic
 * CRUD operations for entities.
 *
 * @author tomasz.huchro, 2016-03-01
 * @param <ID> ID of entity object - Integer.
 * @param <E> Entity type.
 */
public abstract class AbstractDao<ID extends Serializable, E> implements IDao<E> {

    private final Class<E> persistentClass;

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public AbstractDao() {
        this.persistentClass = (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    protected Criteria createEntityCriteria() {
        return getSession().createCriteria(persistentClass);
    }

    @SuppressWarnings("unchecked")
    public E getById(ID id) {
        return (E) getSession().get(persistentClass, id);
    }

    public void persist(E entity) {
        getSession().persist(entity);
    }

    public void update(E entity) { getSession().update(entity);}

    public void delete(E entity) {
        getSession().delete(entity);
    }

    public void deleteList(List<E> list) {
        getSession().delete(list);
    }

    @Override
    public Integer count() {
        return ((Number) createEntityCriteria().setProjection(Projections.rowCount()).uniqueResult()).intValue();
    }

    public List<E> getAll() {
        return getSession().createCriteria(persistentClass).list();
    }

    public List<E> findByMultiCriteria(String[] columns, String... values) {
        Criteria crit = this.getSession().createCriteria(persistentClass);
        for (int i = 0; i < columns.length; i++) {
            crit.add(Restrictions.eq(columns[i], values[i]));
        }
        return crit.list();
    }

    public E getByIdWithRelations(Integer id) {
        E entity = this.getById(id);
        this.initEntityRelations(entity);
        return entity;
    }

    public List<E> getAllWithRelations() {
        List<E> entities = this.getAll();
        this.initListRelations(entities);
        return entities;
    }

    public void initListRelations(List<E> entities) {
        ArrayList<E> list = (ArrayList) entities;
        for (E e : list) {
            this.initEntityRelations(e);
        }
    }

}