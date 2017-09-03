package by.hotel.controller;

import by.hotel.bean.Role;
import by.hotel.bean.User;
import by.hotel.security.MD5;
import by.hotel.service.AuthService;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.impl.AuthServiceImpl;
import by.hotel.util.CheckRole;
import by.hotel.util.SessionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

@Controller
public class AccountController {
    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @RequestMapping(value = "/account", method = RequestMethod.GET )
    public ModelAndView getAccount(HttpServletRequest request) throws SQLException {
        User user = null;
        if (request.getSession().getAttribute("email") == null) {
            return new ModelAndView("redirect:http://localhost:8080/main.jsp#entry");
        }
        String userEmail = request.getSession().getAttribute("email").toString();
        Connection connection = null;
            try {
                connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT `m`.`*`, `u1`.`nameRole` FROM `db_hotel`.`user` `m` INNER JOIN `role` `u1` ON (`m`.`role_id` = `u1`.`id`) WHERE `m`.`email` = ?");
                statement.setString(1,userEmail);
                ResultSet resultSet = statement.executeQuery();
                if (!resultSet.next()){
                    return new ModelAndView("redirect:http://localhost:8080/main.jsp#entry");
                } else {
                    user = new User();
                    resultSet.beforeFirst();
                }
                while (resultSet.next()) {
                    user.setEmail(resultSet.getString("email"));
                    user.setMobilePhone(resultSet.getString("mobilePhone"));
                    user.setPassportNumber(resultSet.getString("passportNumber"));
                    user.setName(resultSet.getString("name"));
                    user.setSurname(resultSet.getString("surname"));
                    user.setPassword(resultSet.getString("password"));
                    user.setLogin(resultSet.getString("login"));
                    SessionHelper.SetUserRoleSession(request,resultSet.getString("nameRole"));
                }
            } catch (Exception e){
                System.out.println(e);
                return new ModelAndView("redirect:http://localhost:8080/main.jsp#entry");
            } finally {
                connection.close();
            }
            ModelAndView model = new ModelAndView("account");
            model.addObject("user",user);
            return model;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public RedirectView localRedirect(HttpServletRequest request) {
        SessionHelper.DeleteUserSession(request);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:8080/main");
        return redirectView;
    }
}
