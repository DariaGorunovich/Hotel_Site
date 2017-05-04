package com.aliaksey.controller;

import com.aliaksey.DAO.ReviewDAO;
import com.aliaksey.DAO.RoomTypeDAO;
import com.aliaksey.DAO.UserDAO;
import com.aliaksey.entity.Review;
import com.aliaksey.entity.RoomType;
import com.aliaksey.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Aliaksey on 02.05.2017.
 */
@Controller
@RequestMapping(value = "/review")
@SessionAttributes("review")
public class ReviewController {

    @Autowired
    ReviewDAO reviewDAO;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(       Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
    }


    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ModelAndView listReviews(ModelAndView model) {

        List<Review> reviews = reviewDAO.getAll();
        model.addObject("reviews", reviews);
        model.setViewName("Review/Reviews");
        return model;
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView deleteReview(@PathVariable("id") int id) {
        reviewDAO.delete(id);
        return new ModelAndView("redirect:/review/list");
    }

    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public ModelAndView newReview(ModelAndView model) {
        Review review = new Review();
       // roomType.setRoomTypeId(0);
        model.addObject("review", review);
        model.setViewName("Review/ReviewsForm");
        return model;
    }

    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public ModelAndView editReviewGet(@PathVariable("id") int id, ModelAndView model,HttpServletResponse response) {
        Review review = reviewDAO.get(id);
        if (review == null) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
        }
        else {
            model.addObject("review", review);
            model.setViewName("Review/ReviewsForm");
        }
        return model;
    }


    @RequestMapping(value = "/edit/{id}",method = RequestMethod.POST)
    public ModelAndView editReviewPost(@Valid @ModelAttribute("review") Review review,
                                         BindingResult result,
                                         SessionStatus sessionStatus) {
        if (result.hasErrors()) {
            return new ModelAndView("Review/ReviewsForm");
        }
        if (review.getReviewId() == 0) {
            reviewDAO.add(review);
        }
        else {
            reviewDAO.update(review);
        }
        sessionStatus.setComplete();
        return new ModelAndView("redirect:/review/list");
    }
}
