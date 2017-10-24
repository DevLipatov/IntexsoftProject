package by.intexsoft.backend.service;

import by.intexsoft.backend.model.Authority;

/**
 * Service that allows performing basic CRUD operations upon {@link Authority}
 * entities
 */
public interface AuthorityService extends AbstractEntityService<Authority> {

    /**
     * Finds {@link Authority} instance in database
     *
     * @param authority name of {@link Authority} instance
     * @return an {@link Authority} instance which was found
     */
    Authority findByAuthority(String authority);
}
