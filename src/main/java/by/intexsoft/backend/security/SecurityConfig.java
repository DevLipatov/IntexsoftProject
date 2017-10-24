package by.intexsoft.backend.security;

import by.intexsoft.backend.service.AuthenticationService;
import by.intexsoft.backend.service.impl.AuthenticationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Java-based Spring Security configuration class
 */
@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = {UserDetailsServiceImpl.class, AuthenticationServiceImpl.class})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationService authenticationService;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/*.html")
                .antMatchers("/*.js")
                .antMatchers("/assets/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/login").permitAll()
                .antMatchers(HttpMethod.POST, "/api/allusers").permitAll()
                .antMatchers(HttpMethod.POST, "/api/registration/").permitAll()
                .antMatchers(HttpMethod.POST, "/api/themes/published").permitAll()
                .antMatchers(HttpMethod.GET, "/api/auction/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/user/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/themes/new").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                .antMatchers(HttpMethod.POST, "/api/user/**").hasAuthority("ROLE_USER")
                .anyRequest().authenticated().and()
                .addFilterBefore(new TokenFilter(authenticationService), UsernamePasswordAuthenticationFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}