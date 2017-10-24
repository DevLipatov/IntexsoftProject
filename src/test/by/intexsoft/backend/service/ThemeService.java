package by.intexsoft.backend.service;

import by.intexsoft.backend.model.Theme;

import java.util.List;

/**
 * Service for {@link by.intexsoft.backend.model.Theme}
 */
public interface ThemeService extends AbstractEntityService<Theme>{
    /**
     * Find all themes with same title
     *
     * @param title - title of searching themes
     * @return list of themes with same title
     */
    List<Theme> findByTitle(String title);

    /**
     * Find all themes with same category by category name
     *
     * @param name - name of category
     * @return list of themes
     */
    List<Theme> findByCategoryName(String name);

    /**
     * Find all themes in database with same category and status
     *
     * @param name - name of category
     * @param status - status of searching themes
     * @return list of themes with same category name and status
     */
    List<Theme> findByCategoryNameAndStatus(String name, String status);

    /**
     * Find all themes with same status
     *
     * @param status - status to find themes
     * @return list of themes with same status
     */
    List<Theme> findByStatus(String status);

    /**
     * Find al themes in database
     *
     * @return list of themes
     */
    List<Theme> findAll();
}
