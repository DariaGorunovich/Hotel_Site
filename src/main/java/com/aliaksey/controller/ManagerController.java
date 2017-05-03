package com.aliaksey.controller;

import com.aliaksey.DAO.RoomTypeDAO;
import com.aliaksey.entity.RoomType;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Aliaksey on 03.05.2017.
 */
@Controller
@RequestMapping(value = "/manage")
@SessionAttributes("roomType")
public class ManagerController {

    @Autowired
    RoomTypeDAO roomTypeDAO;


    @RequestMapping(value = "/roomtypes",method = RequestMethod.GET)
    public ModelAndView listRoomTypes(ModelAndView model) {

        List<RoomType> roomTypes = roomTypeDAO.getAll();
        model.addObject("roomTypes", roomTypes);
        model.setViewName("RoomType/roomTypes");
        return model;
    }

    @RequestMapping(value = "/roomtypes/delete/{id}")
    public ModelAndView deleteRoomType(@PathVariable("id") int id) {
        roomTypeDAO.delete(id);
        return new ModelAndView("redirect:/manage/roomtypes");
    }

    @RequestMapping(value = "/roomtypes/new",method = RequestMethod.GET)
    public ModelAndView newRoomTypeGet(ModelAndView model) {
        RoomType roomType = new RoomType();
        roomType.setRoomTypeId(0);
        model.addObject("roomType", roomType);
        model.setViewName("RoomType/RoomTypeForm");
        return model;
    }

    @RequestMapping(value = "/roomtypes/edit/{id}",method = RequestMethod.GET)
    public ModelAndView editRoomTypeGet(@PathVariable("id") int id, ModelAndView model) {
        RoomType roomType = roomTypeDAO.get(id);
        model.addObject("roomType", roomType);
        model.setViewName("RoomType/RoomTypeForm");
        return model;
    }


    @RequestMapping(value = "/roomtypes/add",method = RequestMethod.POST)
    public ModelAndView editRoomTypePost(@Valid @ModelAttribute("roomType") RoomType roomType,
                                         BindingResult result,
                                         SessionStatus sessionStatus) {
        if (result.hasErrors()) {
            int a = 5;
        }
        if (roomType.getRoomTypeId() == 0) {
            roomTypeDAO.add(roomType);
        }
        else {
            roomTypeDAO.update(roomType);
        }
        sessionStatus.setComplete();
        return new ModelAndView("redirect:/manage/roomtypes");
    }
}
