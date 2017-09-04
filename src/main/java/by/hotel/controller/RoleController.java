package by.hotel.controller;

import by.hotel.util.CheckRole;
import by.hotel.util.SessionHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Controller
public class RoleController {
    private CheckRole checkRole;

    @RequestMapping(value = "/checkrole", method = RequestMethod.GET)
    public int checkRole(HttpServletRequest request) throws SQLException {
        checkRole = new CheckRole();
        String role = checkRole.checkCurrentRole(request.getSession().getAttribute("email").toString());
        if (role != null) {
            SessionHelper.SetUserRoleSession(request,role);
        }
        return 1;
    }
}
