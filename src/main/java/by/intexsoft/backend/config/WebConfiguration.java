package by.intexsoft.backend.config;

import by.intexsoft.backend.service.impl.ThemeServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Java-based configuration class for a dispatcher servlet application context.
 * {@link @EnableWebMvc} configures a list of special bean types the
 * DispatcherServlet relies on
 */
@Configuration
@EnableWebMvc
@ComponentScan("by.intexsoft.backend.controller")
public class WebConfiguration {

    /**
     * @return instance of an ThemeServiceImpl class
     */
    @Bean
    public ThemeServiceImpl themeService() {
        return new ThemeServiceImpl();
    }
}
