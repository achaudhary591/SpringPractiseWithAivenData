package com.simpleproject.simple_project.controllers;

import com.simpleproject.simple_project.entity.UserEntity;
import com.simpleproject.simple_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    public @ResponseBody UserEntity addNewUser(@RequestParam String name, @RequestParam String email) {
        UserEntity springUser = new UserEntity();
        springUser.setUsername(name);
        springUser.setEmail(email);
        userRepository.save(springUser);
        return springUser;

    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("hello")
    public String hello() {
        return "Hello, World!";
    }
}