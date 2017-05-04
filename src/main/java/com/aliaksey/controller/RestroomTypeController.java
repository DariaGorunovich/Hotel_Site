package com.aliaksey.controller;

import com.aliaksey.DAO.RestroomTypeDAO;
import com.aliaksey.entity.RestroomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Kirik on 04.05.2017.
 */
@Controller
@RequestMapping(value = "/manage")
@SessionAttributes("restroomType")
public class RestroomTypeController {

    @Autowired
    RestroomTypeDAO restroomTypeDAO;

    @RequestMapping(value = "/restroomtypes", method = RequestMethod.GET)
    public ModelAndView listRestroomTypes(ModelAndView model) {
        List<RestroomType> restroomTypes = restroomTypeDAO.getAll();
        model.addObject("restroomTypes", restroomTypes);
        model.setViewName("RestroomType/restroomTypes");
        return model;
    }

    @RequestMapping(value = "/restroomtypes/delete/{id}")
    public ModelAndView deleteRestroomType(@PathVariable("id") int id) {
        restroomTypeDAO.delete(id);
        return new ModelAndView("redirect:/manage/restroomtypes");
    }

    @RequestMapping(value = "/restroomtypes/new", method = RequestMethod.GET)
    public ModelAndView newRestroomTypeGet(ModelAndView model) {
        RestroomType restroomType = new RestroomType();
        restroomType.setRestroomTypeId(0);
        model.addObject("restroomType", restroomType);
        model.setViewName("RestroomType/RestroomTypeForm");
        return model;
    }

    @RequestMapping(value = "restroomtypes/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editRestroomTypeGet(@PathVariable("id") int id, ModelAndView model) {
        RestroomType restroomType = restroomTypeDAO.get(id);
        model.addObject("restroomType", restroomType);
        model.setViewName("RestroomType/RestroomTypeForm");
        return model;
    }

    @RequestMapping(value = "/restroomtypes/add", method = RequestMethod.POST)
    public ModelAndView editRestroomTypePost(@Valid @ModelAttribute("restroomType") RestroomType restroomType, BindingResult result, SessionStatus sessionStatus) {
        if (result.hasErrors()) {
            int a = 5;
        }
        if (restroomType.getRestroomTypeId() == 0) {
            restroomTypeDAO.add(restroomType);
        }
        else {
            restroomTypeDAO.update(restroomType);
        }
        sessionStatus.setComplete();
        return new ModelAndView("redirect:/manage/restroomtypes");
    }
}
