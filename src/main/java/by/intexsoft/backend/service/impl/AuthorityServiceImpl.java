package by.intexsoft.backend.service.impl;

import by.intexsoft.backend.model.Authority;
import by.intexsoft.backend.repository.AuthorityRepository;
import by.intexsoft.backend.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service which provides basic functionality for CRUD operations upon {@link Authority}
 * instances
 */
@Service
public class AuthorityServiceImpl extends AbstractEntityServiceImpl<Authority> implements AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public Authority findByAuthority(String authority) {
        return authorityRepository.findByAuthority(authority);
    }
}
