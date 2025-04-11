package com.blogapplication.blogapplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blogapplication.blogapplication.Model.Comment;
import com.blogapplication.blogapplication.Model.Post;
import com.blogapplication.blogapplication.Service.BlogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
    @GetMapping("/search")
    public ResponseEntity<?> search(
    @RequestParam(required = false, defaultValue = "") String param) {
    try {
        if (param.isEmpty()) {
            return ResponseEntity.ok(blogService.getAllPosts());
        }
        List<Post> results = blogService.searchResult(param);
        return ResponseEntity.ok(results);
    } catch (Exception e) {
        return ResponseEntity.badRequest().body("Search failed: " + e.getMessage());
    }
}
    
}
