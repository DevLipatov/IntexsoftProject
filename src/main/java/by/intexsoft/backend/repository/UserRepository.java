package by.intexsoft.backend.repository;

import by.intexsoft.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface for CRUD operations with {@link User} entities
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Find user by it name
     *
     * @param username - name of the user
     * @return {@link User} instance
     */
    User findByUsername(String username);
}
