package by.intexsoft.backend.service;

import by.intexsoft.backend.model.User;
import org.springframework.security.core.Authentication;
import javax.servlet.http.HttpServletRequest;

public interface AuthenticationService {

    /**
     * Create {@link Authentication} instance to set to security context holder
     *
     * @param request - filterChain request from client
     * @return {@link Authentication} instance
     */
    Authentication getAuthentication(HttpServletRequest request);

    /**
     * Create {@link Authentication} instance from requested token
     *
     * @param token - requested token
     * @return {@link Authentication} instance
     */
    Authentication getAuthentication(String token);

    /**
     * Create JWT token
     *
     * @param user - received user
     * @param password - user password
     * @return JWT token
     */
    String generateToken(User user, String password);

}
