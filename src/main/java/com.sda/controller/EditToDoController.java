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

@WebServlet("/to-do/edit")
public class EditToDoController extends HttpServlet {

    private final ToDoService toDoService = new ToDoService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Long id = Long.valueOf(req.getParameter("id"));
        String title = req.getParameter("title");
        String category = req.getParameter("category");
        String dueDate = req.getParameter("dueDate");
        String description = req.getParameter("description");
        ToDoModel toDoModel = new ToDoModel(id, title, Category.valueOf(category),
                LocalDate.now(), LocalDate.parse(dueDate), description);
        String login = (String) req.getSession().getAttribute("login");
        toDoService.edit(login, toDoModel);
        resp.sendRedirect("/to-do/list");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String) req.getSession().getAttribute("login");
        Long id = Long.valueOf(req.getParameter("id"));
        ToDoModel toDoModel = toDoService.getToDo(login, id);
        req.setAttribute("todo", toDoModel);
        req.getRequestDispatcher("/WEB-INF/views/edit.jsp").forward(req, resp);
    }
}
