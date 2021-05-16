package com.todolist.todolist.repository;

import com.todolist.entity.RoleEntity;
import com.todolist.entity.UserEntity;
import com.todolist.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {

    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void createUserTest() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        RoleEntity role = entityManager.find(RoleEntity.class, 1L);
        UserEntity user = new UserEntity();
        user.setUsername("vinhqd");
        user.setPassword(encoder.encode("123456"));
        user.addRole(role);
        UserEntity savedUser = repo.save(user);
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void getAllUserTest() {
        List<UserEntity> users = repo.findAll();
        Assertions.assertThat(users.size()).isGreaterThan(0);
    }

}
