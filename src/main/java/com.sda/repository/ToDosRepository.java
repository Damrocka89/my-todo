package com.sda.repository;

import com.sda.model.Category;
import com.sda.model.ToDoModel;

import java.time.LocalDate;
import java.util.*;

public class ToDosRepository {

    private static Map<String, List<ToDoModel>> toDoList = loadMockToDos();

    public List<ToDoModel> getTodoList(String login) {
        return toDoList.get(login);
    }

    public void addTodoToList(String login, ToDoModel toDoModel) {
        toDoList.get(login).add(toDoModel);
    }

    private static Map<String, List<ToDoModel>> loadMockToDos() {
        ToDoModel toDoModel1 = new ToDoModel(SequenceGenerator.getNextValue(), "shopping", Category.HOME,
                LocalDate.now(), LocalDate.now().plusDays(7), "food, food and more food...");
        ToDoModel toDoModel2 = new ToDoModel(SequenceGenerator.getNextValue(), "read a book", Category.RELAX,
                LocalDate.now(), LocalDate.now().plusDays(15), "relax, Java is waiting...");
        Map<String, List<ToDoModel>> todos = new HashMap<>();
        List<ToDoModel> toDoModelList = new ArrayList<>();
        toDoModelList.add(toDoModel1);
        toDoModelList.add(toDoModel2);
        todos.put("Me", toDoModelList);

        return todos;
    }

    public void remove(String login, Long id) {
        List<ToDoModel> toDoModels = toDoList.get(login);
        ToDoModel toDoModel = toDoModels.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
        toDoModels.remove(toDoModel);
    }

    public void markAsDone(String login, Long id) {
        List<ToDoModel> toDoModels = toDoList.get(login);
        Optional<ToDoModel> first = toDoModels.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
        if (first.isPresent()) {
            first.get().setDone(true);
        }

    }

    public void edit(String login, ToDoModel toDoModel) {
        List<ToDoModel> toDoModels = toDoList.get(login);
        Optional<ToDoModel> first = toDoModels.stream()
                .filter(t -> t.getId().equals(toDoModel.getId()))
                .findFirst();
        if (first.isPresent()) {
            ToDoModel toDoModelOld = first.get();

            toDoModelOld.setCategory(toDoModel.getCategory());
            toDoModelOld.setDescription(toDoModel.getDescription());
            toDoModelOld.setDueDate(toDoModel.getDueDate());
            toDoModelOld.setTitle(toDoModel.getTitle());
        }
    }

    public ToDoModel getToDo(String login, Long id) {
        return toDoList.get(login).stream()
                .filter(t -> t.getId().equals(id))
                .findFirst().orElse(null);
    }
}
