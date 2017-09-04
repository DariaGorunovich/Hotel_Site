package by.hotel.controller;

import by.hotel.util.CheckRole;
import by.hotel.util.SessionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Controller
public class MainController {
    @Autowired
    private CheckRole checkRole;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView main(HttpServletRequest request) throws SQLException {
        Object email = request.getSession().getAttribute("email");
        if (email != null) {
            String role = checkRole.checkCurrentRole(request.getSession().getAttribute("email").toString());
            SessionHelper.SetUserRoleSession(request,role);
        }
        return new ModelAndView("main");
    }
}
