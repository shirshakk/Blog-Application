package com.blogapplication.blogapplication.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogapplication.blogapplication.Model.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment , Integer> {
    
}
