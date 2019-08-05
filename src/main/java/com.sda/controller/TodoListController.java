package com.sda.controller;

import com.sda.model.Category;
import com.sda.service.ToDoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/to-do/list")
public class TodoListController extends HttpServlet {

    private final ToDoService toDoService = new ToDoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String) req.getSession().getAttribute("login");
        req.getSession().setAttribute("todos", toDoService.getTodosList(login));
        req.getSession().setAttribute("login", login);
        req.getSession().setAttribute("categories", Category.values());
        req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
    }
}
