package com.iqmsoft.services;

import com.iqmsoft.domain.User;
import com.iqmsoft.services.base.IService;


public interface IUserService extends IService<User> {

    /**
     * Loads user by user name.
     */
    User findByUserName(String username);

    /**
     * Encodes provided password and checks if its same as one user has.
     */
    boolean isPaswordCorrect(User user, String password);

    /**
     * Encodes new password, sets it to user and updates user.
     */
    void changePassword(User user, String newPassword);
}
