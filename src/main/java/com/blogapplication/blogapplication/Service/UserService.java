package com.blogapplication.blogapplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.blogapplication.blogapplication.Model.User;
import com.blogapplication.blogapplication.Model.UserDetailImplementation;
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
    public ResponseEntity<?> updateUser(User updateUser){
        try{
            Authentication auth=SecurityContextHolder.getContext().getAuthentication();
            UserDetailImplementation userDetail=(UserDetailImplementation) auth.getPrincipal();
            User user=userRepo.findByUserName(userDetail.getUsername());
            if(user==null){
                return ResponseEntity.notFound().build();
            }
            if(updateUser.getPassword()!=null){
                user.setPassword(encoder.encode(updateUser.getPassword()));
            }
            if(updateUser.getEmailId()!=null){
                user.setEmailId(updateUser.getEmailId());
            }
            userRepo.save(user);
            return ResponseEntity.ok().build();
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Failed to update user"+e.getMessage());
        }
    }
    
}
