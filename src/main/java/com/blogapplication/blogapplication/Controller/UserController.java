package com.blogapplication.blogapplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blogapplication.blogapplication.Model.Post;
import com.blogapplication.blogapplication.Model.User;
import com.blogapplication.blogapplication.Service.BlogService;
import com.blogapplication.blogapplication.Service.UserService;

@RestController
public class UserController  {
    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;
    @PostMapping("/register")
    public void RegisterNewUser(@RequestBody User entity){
        userService.RegisterNewUser(entity);
    }
    
    @PostMapping("/addPost")
    public void AddNewPost(@RequestBody Post entity) {
        blogService.addBlog(entity);
    }
    
    
}