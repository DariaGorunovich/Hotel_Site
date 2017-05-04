package com.aliaksey.controller;

import com.aliaksey.DAO.UserDAO;
import com.aliaksey.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(value = "/admin")
@Controller
@SessionAttributes("user")
public class UserInfoController {

    @Autowired
    UserDAO userDAO;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView listUsers(ModelAndView model) {
        List<User> users = userDAO.getAll();
        model.addObject("users", users);
        model.setViewName("User/users");
        return model;
    }

    @RequestMapping(value = "/users/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") int id) {
        userDAO.delete(id);
        return new ModelAndView("redirect:/admin/users");
    }

    @RequestMapping(value = "/users/new", method = RequestMethod.GET)
    public ModelAndView newUser(ModelAndView model) {
        User user = new User();
        user.setUserId(0);
        model.addObject("user", user);
        model.setViewName("User/UserForm");
        return model;
    }

    @RequestMapping(value = "/users/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editUserGet(@PathVariable("id") int id, ModelAndView model) {
        User user = userDAO.get(id);
        model.addObject("user", user);
        model.setViewName("User/UserForm");
        return model;
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public ModelAndView editUserPost(@Valid @ModelAttribute("user") User user, BindingResult result, SessionStatus sessionStatus) {
        if (result.hasErrors()) {
            int a = 5;
        }
        if (user.getUserId() == 0) {
            userDAO.add(user);
        }
        else {
            userDAO.update(user);
        }
        sessionStatus.setComplete();
        return new ModelAndView("redirect:/admin/users");
    }
}
