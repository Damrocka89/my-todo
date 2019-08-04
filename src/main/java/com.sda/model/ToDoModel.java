package com.sda.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
public class ToDoModel {

    private Long id;
    private String title;
    private Category category;
    private LocalDate creationDate;
    private LocalDate dueDate;
    private String description;
    private boolean isDone;

    public ToDoModel(Long id, String title, Category category, LocalDate creationDate, LocalDate dueDate, String description) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
        this.description = description;
    }
}
