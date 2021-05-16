package com.todolist.service;

import com.todolist.dto.TodoDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITodoService {

    List<TodoDto> getAllTodo(Pageable pageable);

    TodoDto saveTodo(TodoDto todoDto);

    void deleteTodos(long[] ids);

}
