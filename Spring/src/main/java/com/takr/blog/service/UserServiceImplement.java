package com.takr.blog.service;

import com.takr.blog.dao.UserRepository;
import com.takr.blog.po.User;
import com.takr.blog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplement implements UserService{


    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {

        User user = userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));

        return user;
    }
}
