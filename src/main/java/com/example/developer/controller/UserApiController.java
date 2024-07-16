package com.example.developer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.developer.dto.AddUserRequest;
import com.example.developer.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserApiController {
    
    private final UserService userService;

    @PostMapping("/user")
    public String signup(AddUserRequest request){

        userService.save(request);

        return "redirect:/login";
    }
}
