package com.blogapplication.blogapplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapplication.blogapplication.Model.Post;
import com.blogapplication.blogapplication.Repo.BlogRepo;

@Service
public class BlogService {
    @Autowired
    private BlogRepo blogRepo;
    public void addBlog(Post post){
        blogRepo.save(post);
    }
}
