package com.blogapplication.blogapplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blogapplication.blogapplication.Model.User;
import com.blogapplication.blogapplication.Model.UserDetailImplementation;
import com.blogapplication.blogapplication.Repo.UserRepo;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user=userRepo.findByuserName(username);
        if(user==null){
            throw new UsernameNotFoundException("User Not Found");
        }
        return new UserDetailImplementation(user);
    }
}
