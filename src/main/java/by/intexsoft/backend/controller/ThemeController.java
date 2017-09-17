package by.intexsoft.backend.controller;

import by.intexsoft.backend.model.Theme;
import by.intexsoft.backend.service.impl.ThemeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 *
 */
@RestController
public class ThemeController {

    private ThemeServiceImpl themeService;

    @Autowired
    public ThemeController(ThemeServiceImpl themeService) {
        this.themeService = themeService;
    }

    @RequestMapping(value = "/themes")
    public List<Theme> getAllAuthors() {
        return themeService.findAll();
    }
}
