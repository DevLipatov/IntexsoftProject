package by.intexsoft.backend.service.impl;

import by.intexsoft.backend.model.Authority;
import by.intexsoft.backend.model.User;
import by.intexsoft.backend.repository.UserRepository;
import by.intexsoft.backend.service.AuthorityService;
import by.intexsoft.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of {@link UserService} which provides CRUD operations with {@link User} instances
 */
@Service
public class UserServiceImpl extends AbstractEntityServiceImpl<User> implements UserService {

    private final UserRepository userRepository;

    private final AuthorityServiceImpl authorityService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, AuthorityServiceImpl authorityService) {
        this.userRepository = userRepository;
        this.authorityService = authorityService;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User register(User user) {
        List<Authority> authorities = new ArrayList<>();
        authorities.add(authorityService.findByAuthority("ROLE_USER"));
        user.authorities = authorities;
        return userRepository.save(user);
    }
}
