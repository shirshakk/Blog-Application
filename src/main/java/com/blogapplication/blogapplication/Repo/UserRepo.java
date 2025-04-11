package com.blogapplication.blogapplication.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogapplication.blogapplication.Model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{
    User findByUserName(String username);
}
