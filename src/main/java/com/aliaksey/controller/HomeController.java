package com.aliaksey.controller;

import com.aliaksey.DAO.RestroomTypeDAO;
import com.aliaksey.entity.RestroomType;
import com.aliaksey.entity.User;
import com.aliaksey.DAO.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Aliaksey on 14.03.2017.
 */
@RestController
@RequestMapping(value = "/home")
public class HomeController {

//    @Autowired
//    private UserRepository userRepository;

    @Autowired
    private RestroomTypeDAO restroomTypeDAO;

//    @RequestMapping(method = RequestMethod.GET)
//    public List<RestroomType> listUsers() {
//      //  List<User> users = userRepository.findAll();
//        List<RestroomType> restroomTypes = restroomTypeDAO.getAll();
//        //model.addObject("users", users);
//        //model.setViewName("index");
//        return restroomTypes;
//    }

//    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
//    public User getUser(@PathVariable Integer id) {
//        User user = userRepository.findOne(id);
//        //model.addObject("users", users);
//        //model.setViewName("index");
//        return user;
//    }
}
