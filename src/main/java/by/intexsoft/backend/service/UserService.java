package by.intexsoft.backend.service;

import by.intexsoft.backend.model.User;

/**
 * Service for {@link User}
 */
public interface UserService extends AbstractEntityService<User> {

    /**
     * Find {@link User} by username
     */
    User findByUsername(String username);
}
