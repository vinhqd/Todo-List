package com.todolist.dto;

import lombok.Data;

@Data
public class TodoDto {

    private Long id;
    private String title;
    private boolean completed = false;

}
