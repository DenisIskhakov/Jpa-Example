package com.example.jpaexampleproject.service;

import com.example.jpaexampleproject.model.Users;
import com.example.jpaexampleproject.reposotory.UserRepository;
import lombok.AllArgsConstructor;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;


    public List<Users> findAllList(){
        return userRepository.findAll();
    }

    public Optional<Users> findById(Long id){
        return userRepository.findById(id);
    }
    public List<Users> findByWork(String work){
        return userRepository.findByWork(work);
    }
//    public List<Users> findByWorkJPQL(){
//       return userRepository.findByWorkJPQL();
//    }
}
