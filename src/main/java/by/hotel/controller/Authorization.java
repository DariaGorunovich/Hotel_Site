package by.hotel.controller;

import by.hotel.bean.User;
import by.hotel.security.MD5;
import by.hotel.service.AuthService;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.impl.AuthServiceImpl;
import by.hotel.util.SessionHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Map;

@Controller
public class Authorization  {
    private static final Logger logger = LogManager.getLogger(Authorization.class.getName());

    @ResponseBody
    @RequestMapping(value = "/authorization", method = RequestMethod.POST, produces = "application/json")
    public Object execute(HttpServletRequest request) throws SQLException {
        User user = null;
        try {
            Map<String, String[]> requestParams = request.getParameterMap();
            String password = requestParams.get("password")[0];
            AuthService service = new AuthServiceImpl();
            user = service.checkUser(requestParams.get("email")[0], password);
            if (user != null) {
                SessionHelper.SetUserSession(request,user);
                return user;
            }
        } catch (ServiceException e) {
            logger.error(e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

}
