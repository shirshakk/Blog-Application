package com.blogapplication.blogapplication.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.blogapplication.blogapplication.Model.Comment;
import com.blogapplication.blogapplication.Model.Post;
import com.blogapplication.blogapplication.Model.User;
import com.blogapplication.blogapplication.Model.UserDetailImplementation;
import com.blogapplication.blogapplication.Repo.BlogRepo;
import com.blogapplication.blogapplication.Repo.CommentRepo;
import com.blogapplication.blogapplication.Repo.UserRepo;

@Service
public class BlogService {
    @Autowired
    private BlogRepo blogRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CommentRepo commentRepo;
    
    
    
    
    public Post addBlog(Post post, MultipartFile imageFile) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetailImplementation userDetail = (UserDetailImplementation) auth.getPrincipal();
        User user = userRepo.findByUserName(userDetail.getUsername());
        post.setUser(user);
        if (imageFile != null && !imageFile.isEmpty()) {
            try {
                post.setImage(imageFile.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to process image file", e);
            }
        }
        return blogRepo.save(post);
    }
    public List<Post> getAllPosts(){
        return blogRepo.findAll();
    }

    public void addComment(Comment comment, int postId){
        Post post=blogRepo.findById(postId).orElse(null);
        if(post!=null){
        Authentication auth=SecurityContextHolder.getContext().getAuthentication();
        UserDetailImplementation userDetail=(UserDetailImplementation) auth.getPrincipal();
        if(userDetail!=null){
            User user=userRepo.findByUserName(userDetail.getUsername());
            comment.setUser(user);
            comment.setPost(post);
            commentRepo.save(comment);
        }
    }
    }
    public List<Post> searchResult(String keyword){
        return blogRepo.findByUser_UserNameContainingIgnoreCaseOrTitleContainingIgnoreCase(keyword,keyword);
    }
}