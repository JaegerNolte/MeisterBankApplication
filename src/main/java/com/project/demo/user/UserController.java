package com.project.demo.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/app_user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody UserModel user) {

        boolean success = userService.login(user.getUsername(), user.getPasswordHash(), user.getEmail());
        return success ? "Login Successful!" : "Invalid credentials";
    }

    @PostMapping("/register")
    public String register(@RequestBody UserModel user) {

        Long id = userService.register(user);
        return id > 0 ? "User registered with ID" + id : "Registration failed.";
    }

}
