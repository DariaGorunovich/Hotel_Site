package com.aliaksey.repository;

import com.aliaksey.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Aliaksey on 22.03.2017.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    //User findByUserName(String userName);
}
