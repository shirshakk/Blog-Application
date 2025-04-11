package com.blogapplication.blogapplication.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapplication.blogapplication.Model.Post;

public interface BlogRepo extends JpaRepository<Post,Integer>{
    List<Post> findByUser_UserNameContainingIgnoreCaseOrTitleContainingIgnoreCase(String user_username, String title);

}
