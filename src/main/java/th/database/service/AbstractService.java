package th.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import th.database.dao.IDao;

/**
 * Base service which provides basic entity operations.
 *
 * @param <E>    Entity
 * @param <EDao> Dao of entity.
 * @author tomasz.huchro, 2016-03-20
 */
@Transactional
public abstract class AbstractService<E, EDao extends IDao<E>> {

    @Autowired
    private IDao<E> dao;

    public E findById(int id) {
        return dao.getById(id);
    }

    public List<E> findAll() {
        return dao.getAll();
    }

    public void delete(E entity) {
        this.dao.delete(entity);
    }

    public void update(E entity) {
        this.dao.update(entity);
    }

    public void deleteList(List<E> entityList) {
        this.dao.deleteList(entityList);
    }

    public void save(E entity) {
        this.dao.persist(entity);
    }

    public Integer count() {
        return dao.count();
    }

    public List<E> findByMultiCriteria(String[] columns, String... values) {
        return this.dao.findByMultiCriteria(columns, values);
    }

    /**
     * Get entity and initialize its relations.
     *
     * @param id ID to search for.
     * @return Entity.
     */
    public E findByIdWithRelations(int id) {
        return this.dao.getByIdWithRelations(id);
    }

    /**
     * Get all entities with initialized relations.
     *
     * @return Entities list.
     */
    public List<E> findAllWithRelations() {
        return this.dao.getAllWithRelations();
    }

    /**
     * Initialize entity relation if needed.
     *
     * @param entity Entity object to initialize relations.
     */
    @Transactional
    public void initEntityRelations(E entity) {
        this.dao.initEntityRelations(entity);
    }

    /**
     * Initialize entity list relation if needed.
     *
     * @param entities List of entities to initialize relations.
     */
    @Transactional
    public void initListRelations(List<E> entities) {
        this.dao.initListRelations(entities);
    }

}