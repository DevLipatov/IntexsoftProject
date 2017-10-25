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
     * Find all themes by their category name and status
     *
     * @param name - category name
     * @param status - status of the themes
     * @return list of themes
     */
    List<Theme> findByCategory_NameAndStatus(String name, String status);

    /**
     * Find all themes with same requested status
     *
     * @param status - status of the themes
     * @return - list of themes
     */
    List<Theme> findByStatus(String status);
}
