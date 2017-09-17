package by.intexsoft.backend.repository;

import by.intexsoft.backend.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface for CRUD operations with {@link Theme} entities
 */
@Repository
public interface ThemeRepository extends JpaRepository<Theme, Long> {
}
