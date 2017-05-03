package com.aliaksey.DAO;

import com.aliaksey.entity.User;

import java.util.List;

/**
 * Created by Aliaksey on 25.04.2017.
 */
public interface UserDAO extends AbstractDAO<User> {
    User findByEmail(String email);
}
