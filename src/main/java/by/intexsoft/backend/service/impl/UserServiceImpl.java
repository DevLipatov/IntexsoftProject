package by.intexsoft.backend.service.impl;

import by.intexsoft.backend.model.User;
import by.intexsoft.backend.repository.UserRepository;
import by.intexsoft.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link UserService} which provides CRUD operations with {@link User} instances
 */
@Service
public class UserServiceImpl extends AbstractEntityServiceImpl<User> implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
