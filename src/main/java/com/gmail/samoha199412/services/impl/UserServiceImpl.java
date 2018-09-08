package com.gmail.samoha199412.services.impl;


import com.gmail.samoha199412.dao.user.UserDao;
import com.gmail.samoha199412.entities.token.Token;
import com.gmail.samoha199412.entities.user.User;
import com.gmail.samoha199412.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private  BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private  UserDao userDao;


    @Override
    public Token registerNewUser(User user) {


//        userDao.saveAndFlush(user);
        return null;

    }

    @Override
    public User createNewUser(@NotNull User user) {

        userDao.saveAndFlush(user);
        return user;
    }
}
