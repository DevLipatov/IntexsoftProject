package by.intexsoft.backend.controller;

import by.intexsoft.backend.model.Category;
import by.intexsoft.backend.service.impl.CategoryServiceImpl;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * A controller class which maps received requests to method
 */
@RestController
public class CategoryController {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(CategoryController.class);

    private CategoryServiceImpl categoryService;

    @Autowired
    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * Get all categories from database
     *
     * @return list of categories
     */
    @RequestMapping(value = "/categories")
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }

    /**
     * Add category to database
     *
     * @param category - category to save/update to database
     * @return created/updated category in database
     */
    @RequestMapping(value = "/category-add", method = RequestMethod.POST)
    public ResponseEntity<Category> update(@RequestBody Category category) {
        categoryService.save(category);
        LOGGER.info("Category is saved to database");
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}
