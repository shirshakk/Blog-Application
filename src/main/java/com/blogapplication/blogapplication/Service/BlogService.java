package com.blogapplication.blogapplication.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapplication.blogapplication.Model.Comment;
import com.blogapplication.blogapplication.Model.Post;
import com.blogapplication.blogapplication.Repo.BlogRepo;
import com.blogapplication.blogapplication.Repo.CommentRepo;

@Service
public class BlogService {
    @Autowired
    private BlogRepo blogRepo;

    @Autowired
    private CommentRepo commentRepo;
    public void addBlog(Post post){
        blogRepo.save(post);
    }

    public List<Post> getAllPosts(){
        return blogRepo.findAll();
    }

    public void addComment(Comment comment){
        commentRepo.save(comment);
    }
    public List<Post> searchResult(String keyword){
        return blogRepo.findByUser_UserNameContainingIgnoreCaseOrTitleContainingIgnoreCase(keyword,keyword);
    }
}