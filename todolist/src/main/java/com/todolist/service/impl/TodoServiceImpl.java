package com.todolist.service.impl;

import com.todolist.converters.TodoConverter;
import com.todolist.dto.TodoDto;
import com.todolist.entity.TodoEntity;
import com.todolist.repository.TodoRepository;
import com.todolist.service.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TodoServiceImpl implements ITodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private TodoConverter todoConverter;

    @Override
    public List<TodoDto> getAllTodo(Pageable pageable) {
        return todoRepository.findAll().stream().map(todo -> todoConverter.toDto(todo)).collect(Collectors.toList());
    }

    @Override
    public TodoDto saveTodo(TodoDto todoDto) {
        TodoEntity todoEntity;
        if (todoDto.getId() != null) {
            todoEntity = todoRepository.getOne(todoDto.getId());
            todoEntity.setTitle(todoDto.getTitle());
            todoEntity.setCompleted(todoDto.isCompleted());
        } else {
            todoEntity = todoConverter.toEntity(todoDto);
        }
        TodoEntity savedTodoEntity = todoRepository.save(todoEntity);
        return todoConverter.toDto(savedTodoEntity);
    }

    @Override
    public void deleteTodos(long[] ids) {
        Arrays.stream(ids).forEach(id -> todoRepository.deleteById(id));
    }
}
