package com.todolist.exceptions;

public class TodoNotExistException extends RuntimeException{

    private String message;

    public TodoNotExistException(String message) {
        super(message);
    }
}
