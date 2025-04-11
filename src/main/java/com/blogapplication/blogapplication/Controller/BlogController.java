package com.blogapplication.blogapplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blogapplication.blogapplication.Model.Comment;
import com.blogapplication.blogapplication.Model.Post;
import com.blogapplication.blogapplication.Service.BlogService;

@RestController
public class BlogController {
    
    @Autowired
    private BlogService blogService;
    @PostMapping("/addPost")
    public void AddNewPost(@RequestBody Post entity) {
        blogService.addBlog(entity);
    }
    @PostMapping("/comment/{postId}")
    public void AddComment(@RequestBody Comment entity) {
        blogService.addComment(entity);
    }
    
}
