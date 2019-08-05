package com.sda.service;

import com.sda.model.User;

import javax.servlet.http.HttpServletRequest;

public class AuthenticationService {

    private final UserService userService = new UserService();

    public boolean authenticate(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = userService.findUser(login);
        if (user != null && user.getLogin().equals(login) && user.getPassword().equals(password)) {
            request.getSession().setAttribute("login", login);
            return true;
        }
        return false;
    }

    public boolean isAuthenticated(HttpServletRequest request) {
        if (request.getSession().getAttribute("login") != null) {
            return true;
        }
        return false;
    }

}
