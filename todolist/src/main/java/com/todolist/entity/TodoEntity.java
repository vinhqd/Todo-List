package com.todolist.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "todo")
@Data
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private boolean completed;

}
