package by.intexsoft.backend.repository;

import by.intexsoft.backend.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface for CRUD operations with {@link Authority} entities
 */
@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    /**
     * Find authority by it name
     *
     * @param authority - authority name
     * @return {@link Authority} instance
     */
    Authority findByAuthority(String authority);
}
