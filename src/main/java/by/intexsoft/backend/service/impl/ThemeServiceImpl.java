package by.intexsoft.backend.service.impl;

import by.intexsoft.backend.model.Theme;
import by.intexsoft.backend.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link by.intexsoft.backend.service.ThemeService} which provides CRUD operations
 * with {@link Theme} instances
 */
@Service
public class ThemeServiceImpl extends AbstractEntityServiceImpl<Theme> {

    private ThemeRepository themeRepository;

    @Autowired
    public ThemeServiceImpl(ThemeRepository themeRepository) {
        this.themeRepository = themeRepository;
    }
}
