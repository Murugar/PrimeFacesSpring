package com.iqmsoft.repositories;

import com.iqmsoft.customrepository.GenericRepository;
import com.iqmsoft.domain.User;


public interface UserRepository extends GenericRepository<User, Long> {
    
    /**
     * Loads User by his unique username.
     */
    User findByUsername(String username);

}
