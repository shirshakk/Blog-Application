package com.blogapplication.blogapplication.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapplication.blogapplication.Model.Post;

public interface BlogRepo extends JpaRepository<Post,Integer>{
    
}
