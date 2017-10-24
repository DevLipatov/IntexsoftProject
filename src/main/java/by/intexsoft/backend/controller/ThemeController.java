package by.intexsoft.backend.controller;

import by.intexsoft.backend.model.Theme;
import by.intexsoft.backend.service.ThemeService;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * A controller class which maps received requests to method
 */
@RestController
public class ThemeController {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(ThemeController.class);
    private ThemeService themeService;

    @Autowired
    public ThemeController(ThemeService themeService) {
        this.themeService = themeService;
    }

    /**
     * Find all published themes in database
     *
     * @return list of themes and/or http status
     */
    @RequestMapping(value = "/themes/published")
    public ResponseEntity<?> getAllPublishedThemes() {
        List<Theme> themes = themeService.findByStatus("published");
        if (themes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(themes, HttpStatus.OK);
    }

    /**
     * Find all themes with same requested title
     *
     * @param title - theme title
     * @return response entity with result of searching and/or http status
     */
    @RequestMapping("/themes/{title}")
    public ResponseEntity<?> findByTitle(@PathVariable("title") String title) {
        List<Theme> themes = themeService.findByTitle(title);
        if (themes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(themes, HttpStatus.OK);
    }

    /**
     * Find themes by category name
     *
     * @param categoryName - category name
     * @return response entity with list of themes and/or http status
     */
    @RequestMapping("/themes/{categoryName}")
    public ResponseEntity<?> findByCategoryName(@PathVariable("categoryName") String categoryName) {
        List<Theme> themes = themeService.findByCategoryName(categoryName);
        if (themes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(themes, HttpStatus.OK);
    }

    /**
     * Save new theme to database
     *
     * @param theme to save to database
     * @return saved theme with http status
     */
    @RequestMapping(value = "/theme-add", method = RequestMethod.POST)
    public ResponseEntity<Theme> update(@RequestBody Theme theme) {
        themeService.save(theme);
        return new ResponseEntity<>(theme, HttpStatus.OK);
    }

    /**
     * Find all themes with "new" status
     *
     * @return response with list of themes and/or http status
     */
    @RequestMapping(value = "/themes/new")
    public ResponseEntity<?> findNew() {
        List<Theme> themes = themeService.findByStatus("new");
        if (themes.isEmpty()) {
            LOGGER.info("No themes with status \"new\" ");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(themes, HttpStatus.OK);
    }

    /**
     * Find all themes with "deleted" status
     *
     * @return response with list of themes and/or http status
     */
    @RequestMapping(value = "/themes/deleted")
    public ResponseEntity<?> findDeleted() {
        List<Theme> themes = themeService.findByStatus("deleted");
        if (themes.isEmpty()) {
            LOGGER.info("No themes with status \"deleted\" ");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(themes, HttpStatus.OK);
    }

    /**
     * Find all "published" themes by category name
     *
     * @param categoryName - name of the category
     * @return list of themes and/or http status
     */
    @RequestMapping(value = "/themes/published/{categoryName}")
    public ResponseEntity<?> findPublishedByCategoryName(@PathVariable("categoryName") String categoryName) {
        List<Theme> themes = themeService.findByCategoryNameAndStatus(categoryName, "published");
        if (themes.isEmpty()) {
            LOGGER.info("No themes with category " + categoryName);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(themes, HttpStatus.OK);
    }

    /**
     * Find theme by id and change it status to deleted
     *
     * @param id - theme id
     * @return response entity with http status and boolean status
     */
    @RequestMapping(value = "/theme/delete/{id}")
    public ResponseEntity<?> deleteThemeById(@PathVariable("id") Long id) {
        Theme theme = themeService.findOne(id);
        theme.status = "deleted";
        theme = themeService.save(theme);
        if (theme != null) {
            LOGGER.info("Theme with id " + id + " successfully marked as deleted");
            return new ResponseEntity<>(theme, HttpStatus.OK);
        }
        LOGGER.info("Can`t delete theme with id: " + id);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
