package com.sda.service;

import com.sda.model.ToDoModel;
import com.sda.repository.ToDosRepository;

import java.util.List;

public class ToDoService {

    private ToDosRepository toDosRepository = new ToDosRepository();

    public void addTodo(String login, ToDoModel toDoModel) {
        toDosRepository.addTodoToList(login, toDoModel);
    }

    public List<ToDoModel> getTodosList(String login) {
       return toDosRepository.getTodoList(login);
    }

    public void remove(String login, Long id){
        toDosRepository.remove(login, id);
    }

    public void markAsDone(String login, Long valueOf) {
        toDosRepository.markAsDone(login,valueOf);
    }

    public void edit(String login, ToDoModel toDoModel) {
        toDosRepository.edit(login, toDoModel);
    }

    public ToDoModel getToDo(String login, Long id) {
        return toDosRepository.getToDo(login, id);
    }
}
