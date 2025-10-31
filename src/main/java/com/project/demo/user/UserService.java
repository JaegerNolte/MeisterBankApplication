package com.project.demo.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//The UserService.java will manipulate User objects without touching SQL directly

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public boolean login (String username, String passwordHash, String email) {

        return repo.authenticateUser(username, passwordHash, email);

    }

    public Long register(UserModel user) {

        return repo.registerUser(user);

    }

}
