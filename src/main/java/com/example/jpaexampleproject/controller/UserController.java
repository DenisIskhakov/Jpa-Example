package com.example.jpaexampleproject.controller;

import com.example.jpaexampleproject.model.Users;
import com.example.jpaexampleproject.service.UserJpaService;
import com.example.jpaexampleproject.service.UserService;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    private UserJpaService userJpaService;

    @GetMapping()
    public ResponseEntity<List<Users>> getList(){
        return new ResponseEntity<>(userService.findAllList(), HttpStatus.OK);
    }

    @GetMapping("/UserJpaGetAll")
    public ResponseEntity<List<Users>> getAllList(){
        return new ResponseEntity<>(userJpaService.findAllSQL(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Users>> getById(@PathVariable Long id){
        return new ResponseEntity<Optional<Users>>(userService.findById(id),HttpStatus.OK);
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Users>> findByIdUsers(@PathVariable String name){
        return new ResponseEntity<Users>((Users) userJpaService.findByIdUsersSQL(name),HttpStatus.OK);
    }
    @GetMapping("/work/{work}") //адрес не должен повторять!!!
    public ResponseEntity<List<Users>> findByWork(@PathVariable String work){
        return new ResponseEntity<>(userService.findByWork(work),HttpStatus.OK);
    }
//    @GetMapping("/{work}")
//    public ResponseEntity<List<Users>> findByWorkJPQL(){
//        return new ResponseEntity<>(userService.findByWorkJPQL(),HttpStatus.OK);
//    }
}
