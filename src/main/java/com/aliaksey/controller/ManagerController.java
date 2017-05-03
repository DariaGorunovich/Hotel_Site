package com.aliaksey.controller;

import com.aliaksey.DAO.RoomTypeDAO;
import com.aliaksey.entity.RoomType;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import java.util.List;

/**
 * Created by Aliaksey on 03.05.2017.
 */
@Controller
@RequestMapping(value = "/manage")
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

    @RequestMapping(value = "/roomTypes/delete/{id}")
    public ModelAndView deleteRoomType(@PathVariable("id") int id) {
        roomTypeDAO.delete(id);
        return new ModelAndView("redirect:/manage/roomtypes");
    }

    @RequestMapping(value = "/roomTypes/new",method = RequestMethod.GET)
    public ModelAndView newRoomTypeGet(ModelAndView model) {
        RoomType roomType = new RoomType();
        roomType.setRoomTypeId(0);
        model.addObject("roomType", roomType);
        model.setViewName("RoomType/RoomTypeForm");
        return model;
    }

    @RequestMapping(value = "/roomTypes/edit/{id}",method = RequestMethod.GET)
    public ModelAndView editRoomTypeGet(@PathVariable("id") int id, ModelAndView model) {
        RoomType roomType = roomTypeDAO.get(id);
        model.addObject("roomType", roomType);
        model.setViewName("RoomType/RoomTypeForm");
        return model;
    }


    @RequestMapping(value = "/roomTypes/add",method = RequestMethod.POST)
    @SessionAttributes(value = "roomType")
    public ModelAndView editRoomTypePost(Model model, @ModelAttribute("roomType") RoomType roomType) {
        roomType.get
        if (roomType.getRoomTypeId() == 0) {
            roomTypeDAO.add(roomType);
        }
        else {
            roomTypeDAO.update(roomType);
        }

        return new ModelAndView("redirect:/manage/roomtypes");
    }
}
