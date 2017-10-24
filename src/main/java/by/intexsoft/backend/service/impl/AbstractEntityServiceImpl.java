package by.intexsoft.backend.service.impl;

import by.intexsoft.backend.model.AbstractEntity;
import by.intexsoft.backend.service.AbstractEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Realisation of {@link AbstractEntityService}
 *
 * @param <T> - type of target operation entity
 */
public class AbstractEntityServiceImpl<T extends AbstractEntity> implements AbstractEntityService<T> {

    @Autowired
    JpaRepository<T, Long> repository;

    @Override
    public void delete(long id) {
        repository.delete(id);
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public T findOne(long id) {
        return repository.findOne(id);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }
}
