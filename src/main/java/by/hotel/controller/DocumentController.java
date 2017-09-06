package by.hotel.controller;

import by.hotel.util.CheckRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Controller
public class DocumentController {
    @Autowired
    private CheckRole checkRole;

    @RequestMapping(value = "/documents", method = RequestMethod.GET)
    public ModelAndView main(HttpServletRequest request) throws SQLException {
        checkRole.checkCurrentRole(request);
        if (request.getSession().getAttribute("email") == null) {
            return new ModelAndView("redirect:http://localhost:8080/main.jsp#entry");
        }
        return new ModelAndView("documents");
    }
}
