package by.hotel.controller;

/**
 * Created by Dashutka on 27.08.2017.
 */

import by.hotel.service.TablesInfoService;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.impl.TablesInfoServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import by.hotel.bean.Feedback;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class GetFeedback {
    @RequestMapping(value = "/feedback", method = RequestMethod.GET)
    public ModelAndView feedback() {
        return new ModelAndView("feedback", "Feedback", new Feedback());
    }
    @RequestMapping(value = "/getFeed", method = RequestMethod.POST)
    public String getFeed(@ModelAttribute("SpringWeb")Feedback feedback,ModelMap model) {
        HttpServletRequest request;
        model.addAttribute("name", "OLOLO");
        model.addAttribute("feedback", "POPOPO");

        return "feedback";
    }
}

