package by.hotel.controller;

import by.hotel.bean.Room;
import by.hotel.bean.RoomType;
import by.hotel.bean.User;
import by.hotel.service.CrudService;
import by.hotel.service.CrudServiceMapper;
import by.hotel.util.SessionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Controller
public class ServicesController {
    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @RequestMapping(value = "/services", method = RequestMethod.GET )
    public ModelAndView getAccount(HttpServletRequest request) throws SQLException {

        Connection connection = null;
        List<Room> resultList = null;
        try {
            CrudService service =  CrudServiceMapper.getService("room");
            resultList = service.getAllEntities();
        } catch (Exception e){
            System.out.println(e);
        }
        ModelAndView model = new ModelAndView("rooms");
        model.addObject("rooms",resultList);
        return model;
    }
}
