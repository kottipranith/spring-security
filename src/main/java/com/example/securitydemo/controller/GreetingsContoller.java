package com.example.securitydemo.controller;

import com.example.securitydemo.Service.UserService;
import com.example.securitydemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class GreetingsContoller {

    @Autowired
    private UserService userService;
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello";
    }


    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String userEndPoint(){
        return "Hello, I am a normal user";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String adminEndPoint(){
        return "Hello, I am an Admin";
    }

    @PostMapping("/adduser")
    public String addUser(@RequestBody User user){
        System.out.println(user);
        userService.addUser(user);
        return "User added";
    }

    @GetMapping("/adduser")
    public String temp(){
        return "Getting";
    }
}
