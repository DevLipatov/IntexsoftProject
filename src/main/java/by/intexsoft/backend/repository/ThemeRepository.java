package by.intexsoft.backend.repository;

import by.intexsoft.backend.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Interface for CRUD operations with {@link Theme} entities
 */
@Repository
public interface ThemeRepository extends JpaRepository<Theme, Long> {
    /**
     * Find theme by it title
     *
     * @param title - title of searching theme
     * @return list of themes with same titles
     */
    List<Theme> findByTitle(String title);

    /**
     * Find themes by their category
     *
     * @param name - category name
     * @return - list of themes with same category
     */
    List<Theme> findByCategoryName(String name);

    /**
     * @param name
     * @param status
     * @return
     */
    List<Theme> findByCategory_NameAndStatus(String name, String status);

    /**
     * @param status
     * @return
     */
    List<Theme> findByStatus(String status);
}
