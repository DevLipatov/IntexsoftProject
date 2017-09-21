package by.intexsoft.backend.controller;

import by.intexsoft.backend.model.Category;
import by.intexsoft.backend.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Category controller. Provides CRUD operations for {@link Category} entity from database
 */
@RestController
public class CategoryController {

    private CategoryServiceImpl categoryService;

    @Autowired
    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/categories")
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }
}
