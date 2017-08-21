package by.hotel.controller;

import by.hotel.bean.User;
import by.hotel.security.MD5;
import by.hotel.service.AuthService;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.impl.AuthServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

@Controller
@Scope("session")
public class Authorization  {
    private static final Logger logger = LogManager.getLogger(Authorization.class.getName());

    @ResponseBody
    @RequestMapping(value = "/authorization", method = RequestMethod.POST, produces = "application/json")
    public Object execute(HttpServletRequest request){
        User user = null;
        try {
            Map<String, String[]> requestParams = request.getParameterMap();
            AuthService service = new AuthServiceImpl();
            user = service.checkUser(requestParams.get("email")[0], MD5.crypt(requestParams.get("password")[0]));
//            Authentication authentication = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
//            SecurityContextHolder.getContext().setAuthentication(authentication);

            boolean isAuth = SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
            return user;
        } catch (ServiceException e) {
            logger.error(e);
        }
        return user;
    }

    @RequestMapping(value = "/authorization", method = RequestMethod.GET)
    public RedirectView localRedirect() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:8080/main.jsp#entry");
        return redirectView;
    }
}
