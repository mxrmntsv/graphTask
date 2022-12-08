package com.application.sobesTask.dao;

import com.application.sobesTask.entity.User;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, UUID> {
    List<User> findAllById();
}
