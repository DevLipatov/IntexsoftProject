package by.intexsoft.backend.repository;

import by.intexsoft.backend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface for CRUD operations with {@link Category} entities
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
