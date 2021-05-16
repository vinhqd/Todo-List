package com.todolist.api;

import com.todolist.dto.TodoDto;
import com.todolist.service.impl.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;

@RestController
@RequestMapping("/api/todos")
public class TodoApi {

    @Autowired
    private TodoServiceImpl todoService;

    @GetMapping
    public ResponseEntity<?> getAllTodos() {
        Pageable pageable = PageRequest.of(0, 5);
        return ResponseEntity.ok(todoService.getAllTodo(pageable));
    }

    @PostMapping
    public ResponseEntity<?> createTodo(@RequestBody TodoDto todoDto) {
        todoDto = todoService.saveTodo(todoDto);
        return ResponseEntity.ok(todoDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTodo(@RequestBody TodoDto todoDto, @PathVariable("id") Long id) {
        todoDto.setId(id);
        try {
            todoDto = todoService.saveTodo(todoDto);
            return ResponseEntity.ok(todoDto);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteTodos(@RequestBody long[] ids) {
        try {
            todoService.deleteTodos(ids);
            return ResponseEntity.ok(Arrays.toString(ids) + " deleted.");
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }

    }

}
