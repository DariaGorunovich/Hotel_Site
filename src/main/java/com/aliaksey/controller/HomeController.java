package com.aliaksey.controller;

import com.aliaksey.entity.User;
import com.aliaksey.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Aliaksey on 14.03.2017.
 */
@RestController
@RequestMapping(value = "/home")
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> listUsers() {
        List<User> users = userRepository.findAll();
        //model.addObject("users", users);
        //model.setViewName("index");
        return users;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getUser(@PathVariable Integer id) {
        User user = userRepository.findOne(id);
        //model.addObject("users", users);
        //model.setViewName("index");
        return user;
    }
}
