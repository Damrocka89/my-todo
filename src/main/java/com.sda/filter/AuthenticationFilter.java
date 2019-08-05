package com.sda.filter;

import com.sda.service.AuthenticationService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/to-do/*")
public class AuthenticationFilter extends HttpFilter {

    private final AuthenticationService authenticationService = new AuthenticationService();

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (authenticationService.isAuthenticated(req)) {
            super.doFilter(req, res, chain);
        } else {
            res.sendRedirect("/login");
        }
    }
}
