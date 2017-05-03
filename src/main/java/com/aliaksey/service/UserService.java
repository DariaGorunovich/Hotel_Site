package com.aliaksey.service;

import com.aliaksey.entity.User;

/**
 * Created by Aliaksey on 30.04.2017.
 */
public interface UserService {
    void add(User user);

    User findByEmail(String email);
}
