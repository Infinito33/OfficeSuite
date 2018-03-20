package th.database.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IService<E> {

    public E findById(int id);

    public List<E> findAll();

    public void delete(E entity);

    public void update(E entity);

    public void deleteList(List<E> entityList);

    public void save(E entity);

    public List<E> findByMultiCriteria(String[] columns, String... values);

    public Integer count();

    /**
     * Get entity and initialize its relations.
     *
     * @param id ID to search for.
     * @return Entity.
     */
    public E findByIdWithRelations(int id);

    /**
     * Get all entities with initialized relations.
     *
     * @return Entities list.
     */
    public List<E> findAllWithRelations();

    /**
     * Initialize entity relation if needed.
     *
     * @param entity Entity object to initialize relations.
     */
    @Transactional
    public void initEntityRelations(E entity);

    /**
     * Initialize entity list relation if needed.
     *
     * @param entities List of entities to initialize relations.
     */
    @Transactional
    public void initListRelations(List<E> entities);
}
