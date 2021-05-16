package com.todolist.todolist.repository;

import com.todolist.repository.TodoRepository;
import com.todolist.entity.TodoEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class TodoRepositoryTests {

    @Autowired
    private TodoRepository repo;

    @Test
    public void createTodo() {
        TodoEntity todo = new TodoEntity();
        todo.setTitle("Make coffee");
        todo.setCompleted(false);
        TodoEntity savedTodo = repo.save(todo);

        Assertions.assertThat(savedTodo).isNotNull();
    }

}
