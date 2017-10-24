package by.intexsoft.backend.controller;

import by.intexsoft.backend.model.User;
import by.intexsoft.backend.service.UserService;
import by.intexsoft.backend.service.impl.UserServiceImpl;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * A controller class which maps received requests to method
 */
@RestController
public class UserController {

    private final static Logger LOGGER = (Logger) LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    /**
     * Save user to database
     *
     * @param user - user to add to database
     * @return {@link ResponseEntity} and HTTP status code
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<?> register(@RequestBody User user) {
        LOGGER.info("Request was received to create new user");
        User createdUser = userService.register(user);
        if (createdUser != null) {
            LOGGER.info("New user was successfully created");
            return new ResponseEntity<>(createdUser, HttpStatus.OK);
        } else {
            LOGGER.warn("Request to created a new user failed");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
