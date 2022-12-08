package com.application.sobesTask.dao;

import com.application.sobesTask.entity.User;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDao {
    private final UserRepo userRepo;

    public void saveUser(List<User> userList) {
        userRepo.saveAll(userList);
    }

    public List<User> getUsers() {
        return userRepo.findAllById();
    }
}
