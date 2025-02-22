package com.example.demo.controller;

import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {
    @GetMapping("/welcome")
    public String welcome(@RequestParam("name") String name) {
//        String username = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        return "Welcome to Spring Boot, " + name + "!";
    }
}
