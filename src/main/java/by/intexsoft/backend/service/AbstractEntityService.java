package by.intexsoft.backend.service;

import by.intexsoft.backend.model.AbstractEntity;
import java.util.List;

/**
 * Global interface for general CRUD operations
 */
public interface AbstractEntityService<T extends AbstractEntity> {

    /**
     * Deletes entity fron database with given id
     *
     * @param id - identifier of an entity
     */
    void delete(long id);

    /**
     * Save entity to database
     *
     * @param entity - entity which will be saved to database
     * @return saved entity
     */
    T save(T entity);

    /**
     * Get entity by it id
     *
     * @param id - identifier of an entity in database
     * @return target entity
     */
    T findOne(long id);

    /**
     * Get all entities from database
     *
     * @return list of entities
     */
    List<T> findAll();
}
