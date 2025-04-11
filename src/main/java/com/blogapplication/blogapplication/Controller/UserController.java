package com.blogapplication.blogapplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blogapplication.blogapplication.Model.Post;
import com.blogapplication.blogapplication.Model.User;
import com.blogapplication.blogapplication.Service.BlogService;
import com.blogapplication.blogapplication.Service.UserService;
import org.springframework.web.bind.annotation.GetMapping;


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
    @GetMapping("/home")
    public List<Post> AllPost() {
        List<Post> posts=blogService.getAllPosts();
        return posts;
    }

}