package com.sda.controller;

import com.sda.model.Category;
import com.sda.model.ToDoModel;
import com.sda.repository.SequenceGenerator;
import com.sda.service.ToDoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/to-do/save")
public class SaveToDoController extends HttpServlet {

    private final ToDoService toDoService = new ToDoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String title = req.getParameter("title");
        String category = req.getParameter("category");
        String dueDate = req.getParameter("dueDate");
        String description = req.getParameter("description");
        ToDoModel toDoModel = new ToDoModel(SequenceGenerator.getNextValue(), title, Category.valueOf(category),
                LocalDate.now(), LocalDate.parse(dueDate), description);
        String login = (String) req.getSession().getAttribute("login");
        toDoService.addTodo(login, toDoModel);
        resp.sendRedirect("/to-do/list");
    }

}
