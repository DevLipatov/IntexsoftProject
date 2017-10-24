package by.intexsoft.backend.service.impl;

import by.intexsoft.backend.model.Theme;
import by.intexsoft.backend.repository.ThemeRepository;
import by.intexsoft.backend.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Implementation of {@link by.intexsoft.backend.service.ThemeService} which provides CRUD operations
 * with {@link Theme} instances
 */
@Service
public class ThemeServiceImpl extends AbstractEntityServiceImpl<Theme> implements ThemeService {

    @Autowired
    private ThemeRepository themeRepository;

    @Override
    public List<Theme> findByTitle(String title) {
        return themeRepository.findByTitle(title);
    }

    @Override
    public List<Theme> findByCategoryName(String name) {
        return themeRepository.findByCategoryName(name);
    }

    @Override
    public List<Theme> findByCategoryNameAndStatus(String name, String status) {
        return themeRepository.findByCategory_NameAndStatus(name, status);
    }

    @Override
    public List<Theme> findByStatus(String status) {
        return themeRepository.findByStatus(status);
    }

    @Override
    public List<Theme> findAll() {
        return themeRepository.findAll();
    }
}
