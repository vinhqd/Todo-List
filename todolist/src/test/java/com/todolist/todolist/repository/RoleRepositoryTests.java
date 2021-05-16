package com.todolist.todolist.repository;

import com.todolist.entity.RoleEntity;
import com.todolist.repository.RoleRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class RoleRepositoryTests {

    @Autowired
    private RoleRepository repo;

    @Test
    public void createRoleTest() {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName("USER");
        RoleEntity savedRole = repo.save(roleEntity);
        Assertions.assertThat(savedRole.getId()).isGreaterThan(0);
    }

    @Test
    public void getAllRoleTest() {
        List<RoleEntity> roles = repo.findAll();
        Assertions.assertThat(roles.size()).isGreaterThan(0);
    }

}
