package by.hotel.controller;

import by.hotel.bean.User;
import by.hotel.service.CrudService;
import by.hotel.service.RegistrationService;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.impl.RegistrationServiceImpl;
import by.hotel.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class Registration  {
    private static final Logger logger = LogManager.getLogger(Registration.class.getName());

    @ResponseBody
    @RequestMapping(value = "/registration", method = RequestMethod.POST, produces = "application/json")
    public Object execute(HttpServletRequest req, HttpServletResponse res){
        Map<String, String[]> requestParams = req.getParameterMap();
        User user = null;
        try {
            RegistrationService registrationService = new RegistrationServiceImpl();
            CrudService<User> userService = new UserServiceImpl();
            user = registrationService.registration(userService.buildEntity(requestParams));
            user.setTempPassword(requestParams.get("password")[0]);
        } catch (ServiceException e) {
           logger.error(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return user;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public RedirectView localRedirect() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:8080/main.jsp#entry");
        return redirectView;
    }

    public static String getRights(User user){
        StringBuilder rights = new StringBuilder();
        rights.append(user.getRole().getUpdate());
        rights.append(user.getRole().getDelete());
        rights.append(user.getRole().getInsert());
        rights.append(user.getRole().getCreate());
        rights.append(user.getRole().getSelect());
        rights.append(user.getRole().getDrop());
        rights.append(user.getRole().getGrant());
        return rights.toString();
    }
}
