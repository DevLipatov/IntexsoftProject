package by.intexsoft.backend.service;

import by.intexsoft.backend.model.User;
import java.util.List;

/**
 * Service for {@link User}
 */
public interface UserService extends AbstractEntityService<User> {

    /**
     * Find {@link User} by it name
     */
    User findByUsername(String username);

    /**
     * Save user to database
     * @param user - saved {@link User}
     * @return
     */
    User register(User user);

    /**
     * Find all users
     * @return list of {@link User} instances
     */
    List<User> findAll();
}
