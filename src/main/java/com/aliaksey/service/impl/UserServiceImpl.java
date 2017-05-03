package com.aliaksey.service.impl;

import com.aliaksey.DAO.RoleDAO;
import com.aliaksey.DAO.UserDAO;
import com.aliaksey.entity.Role;
import com.aliaksey.entity.User;
import com.aliaksey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Aliaksey on 30.04.2017.
 */
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Autowired
    RoleDAO roleDAO;

    public void add(User user) {
        user.setPasswordHash(user.getPasswordHash());
        user.setRoles(new HashSet<Role>(Arrays.asList(roleDAO.getByName("ROLE_USER"))));
        userDAO.add(user);
    }

    public User findByEmail(String email) {
        return userDAO.findByEmail(email);
    }
}
