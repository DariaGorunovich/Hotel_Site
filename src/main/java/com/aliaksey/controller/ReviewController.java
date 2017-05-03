package com.aliaksey.controller;

import com.aliaksey.DAO.ReviewDAO;
import com.aliaksey.DAO.UserDAO;
import com.aliaksey.entity.Review;
import com.aliaksey.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Aliaksey on 02.05.2017.
 */
@Controller
@RequestMapping(value = "/review")
public class ReviewController {

    @Autowired
    ReviewDAO reviewDAO;

    @Autowired
    UserDAO userDAO;



    @RequestMapping(value = "/reviews",method = RequestMethod.GET)
    public ModelAndView listReviews(ModelAndView model) {
        //  List<User> users = userRepository.findAll();
        List<Review> reviews = reviewDAO.getAllReviews();
        model.addObject("reviews", reviews);
        model.setViewName("reviews");
        return model;
    }

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public ModelAndView listUsers(ModelAndView model) {
        //  List<User> users = userRepository.findAll();
        List<User> users = userDAO.getAll();
        model.addObject("users", users);
        model.setViewName("index");
        return model;
    }
}
