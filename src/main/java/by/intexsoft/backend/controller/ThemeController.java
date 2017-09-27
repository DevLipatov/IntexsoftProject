package by.intexsoft.backend.controller;

import by.intexsoft.backend.model.Theme;
import by.intexsoft.backend.service.impl.ThemeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    /**
     * Get all themes from database
     */
    @RequestMapping(value = "/themes")
    public List<Theme> getAllThemes() {
        return themeService.findAll();
    }

    /**
     * Add theme to database
     */
    @RequestMapping(value = "/theme-add", method = RequestMethod.POST)
    public ResponseEntity<Theme> update(@RequestBody Theme theme) {
        themeService.save(theme);
        return new ResponseEntity<>(theme, HttpStatus.OK);
    }

    /**
     * Find one theme by id
     * @param id - theme id
     * @return response entity with theme and status - OK
     */
    @RequestMapping(value = "/theme/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findOne(@PathVariable("id") Long id) {
        Theme theme = themeService.findOne(id);
        return new ResponseEntity<>(theme, HttpStatus.OK);
    }
}
