package by.hotel.util;

import by.hotel.bean.User;

import javax.servlet.http.HttpServletRequest;

public class SessionHelper {
    public static void SetUserSession(HttpServletRequest request, User user) {
        request.getSession().setAttribute("email",user.getEmail());
        request.getSession().setAttribute("login", user.getLogin());
        request.getSession().setAttribute("id", user.getId());
        request.getSession().setAttribute("role", user.getRole().getNameRole());
    }

    public static void DeleteUserSession(HttpServletRequest request) {
        request.getSession().removeAttribute("email");
        request.getSession().removeAttribute("login");
        request.getSession().removeAttribute("id");
        request.getSession().removeAttribute("role");
    }

    public static void SetUserRoleSession(HttpServletRequest request, String role) {
        request.getSession().setAttribute("role", role);
    }
}
