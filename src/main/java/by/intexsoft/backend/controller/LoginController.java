package by.intexsoft.backend.controller;

import by.intexsoft.backend.model.TokenObject;
import by.intexsoft.backend.model.User;
import by.intexsoft.backend.service.AuthenticationService;
import by.intexsoft.backend.service.UserService;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * A controller class which maps received requests to method
 */
@RestController
public class LoginController {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(LoginController.class);

    private final UserService userService;
    private final AuthenticationService authenticationService;

    @Autowired
    public LoginController(UserService userService, AuthenticationService authenticationService) {
        this.userService = userService;
        this.authenticationService = authenticationService;
    }

    /**
     * Search user in database and generate token
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> authenticate(@RequestBody User requestUser) {
        User user = userService.findByUsername(requestUser.username);
        LOGGER.info("User received from database: " + user.username );
        if (user.password.equals(requestUser.password)) {
            String token = authenticationService.generateToken(user, requestUser.password);
            if (token != null) {
                TokenObject tokenObject = new TokenObject();
                String role = user.authorities.get(0).authority;
                tokenObject.username = user.username;
                tokenObject.role = role;
                tokenObject.token = token;
                LOGGER.info("Authentication is successful");
                return new ResponseEntity<>(tokenObject, HttpStatus.OK);
            }
        }
        LOGGER.info("Authentication failed");
        return new ResponseEntity<>("Authentication failed", HttpStatus.BAD_REQUEST);
    }
}
