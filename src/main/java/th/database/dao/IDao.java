package th.database.dao;

import java.util.List;

/**
 * Basic interface for CRUD operations
 *
 * @author tomasz.huchro, 2016-03-15
 * @param <E> Entity object.
 */
public interface IDao<E> {

    public E getById(Integer id);

    public void persist(E entity);

    public void update(E entity);

    public void delete(E entity);

    public void deleteList(List<E> list);

    public List<E> getAll();

    public Integer count();

    /**
     * Get entity list and initialize it relations.
     *
     * @return Entity list with initialized relations.
     */
    public List<E> getAllWithRelations();

    /**
     * Searches for entity by multiple criterias within entity's table.
     *
     * @param columns Column names for entity table.
     * @param values Values that will be searched for. Order must be the same as
     * restrictions, as well as amount.
     * @return List of entity.
     */
    public List<E> findByMultiCriteria(String[] columns, String... values);

    /**
     * Get entity and initialize its relations.
     *
     * @param id ID to search for.
     * @return Entity.
     */
    public E getByIdWithRelations(Integer id);

    /**
     * Initialize relations in list of entities.
     *
     * @param entities List of entities.
     */
    public void initListRelations(List<E> entities);

    /**
     * Initialize entity relation if needed.
     *
     * @param entity Entity object to initialize relations.
     */
    public void initEntityRelations(E entity);
}
