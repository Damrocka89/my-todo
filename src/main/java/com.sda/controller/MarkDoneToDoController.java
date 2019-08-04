package com.sda.controller;

import com.sda.service.ToDoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/markAsDone")
public class MarkDoneToDoController extends HttpServlet {

    private final ToDoService toDoService=new ToDoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String login = (String) req.getSession().getAttribute("login");
        toDoService.markAsDone(login, Long.valueOf(id));
        resp.sendRedirect("/list");
    }

}
