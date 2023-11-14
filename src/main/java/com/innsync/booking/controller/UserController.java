package com.innsync.booking.controller;

import com.innsync.booking.model.User;
import com.innsync.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("innsync/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return users;
    }

    @PostMapping("/new")
    public ResponseEntity<User> createUser(@RequestBody User user){
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUser(@PathVariable String username){
        userService.findUserByUsername(username);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
