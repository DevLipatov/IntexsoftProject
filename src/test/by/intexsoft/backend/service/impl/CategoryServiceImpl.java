package by.intexsoft.backend.service.impl;

import by.intexsoft.backend.model.Category;
import by.intexsoft.backend.repository.CategoryRepository;
import by.intexsoft.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link CategoryService} which provides CRUD operations
 * with {@link by.intexsoft.backend.model.Category} instances
 */
@Service
public class CategoryServiceImpl extends AbstractEntityServiceImpl<Category> implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;
}
