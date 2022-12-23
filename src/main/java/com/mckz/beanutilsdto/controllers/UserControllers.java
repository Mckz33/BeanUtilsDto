package com.mckz.beanutilsdto.controllers;

import com.mckz.beanutilsdto.Dtos.UserDto;
import com.mckz.beanutilsdto.models.UserModel;
import com.mckz.beanutilsdto.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/user")
public class UserControllers {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserModel userModel){
        return new ResponseEntity<>(userService.create(userModel), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

}
