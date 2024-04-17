package com.workintech.backend.controller;

import com.workintech.backend.dto.UserResponse;
import com.workintech.backend.entity.User;
import com.workintech.backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/")
    public List<UserResponse> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserResponse findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @PostMapping("/")
    public UserResponse save(@RequestBody User user){
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public UserResponse delete(@PathVariable Long id){
        return userService.delete(id);
    }


}
