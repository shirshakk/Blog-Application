package com.blogapplication.blogapplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.blogapplication.blogapplication.Model.User;
import com.blogapplication.blogapplication.Repo.UserRepo;

@Service
public class UserService {
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
    @Autowired
    private UserRepo userRepo;
    public void RegisterNewUser(User entity){
        entity.setPassword(encoder.encode(entity.getPassword()));
        userRepo.save(entity);
    }
}
