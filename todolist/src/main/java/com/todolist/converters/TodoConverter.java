package com.todolist.converters;

import com.todolist.dto.TodoDto;
import com.todolist.entity.TodoEntity;
import org.springframework.stereotype.Component;

@Component
public class TodoConverter implements IModelConverter<TodoDto, TodoEntity> {

    @Override
    public TodoDto toDto(TodoEntity entity) {
        TodoDto todoDto = new TodoDto();
        todoDto.setTitle(entity.getTitle());
        todoDto.setId(entity.getId());
        todoDto.setCompleted(entity.isCompleted());
        return todoDto;
    }

    @Override
    public TodoEntity toEntity(TodoDto dto) {
        TodoEntity entity = new TodoEntity();
        if (dto.getId() != null) {
            entity.setId(dto.getId());
        }
        entity.setTitle(dto.getTitle());
        entity.setCompleted(dto.isCompleted());
        return entity;
    }
}
