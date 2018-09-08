package com.gmail.samoha199412.services.impl;

import com.gmail.samoha199412.dao.token.TokenDao;
import com.gmail.samoha199412.dao.user.UserDao;
import com.gmail.samoha199412.entities.token.Token;
import com.gmail.samoha199412.entities.user.User;
import com.gmail.samoha199412.services.TokenServise;
import com.gmail.samoha199412.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import java.util.Calendar;
import java.util.Date;

@Service
public class TokeServiceImpl implements TokenServise {

    private int EXPIRE_HOUR = 24;
    private int REFRESH_EXPIRE_HOUR = 30;

    private final UserService userService;
    private final UserDao userDao;
    private final TokenServise tokenServise;
    private final TokenDao tokenDao;

    @Autowired
    public TokeServiceImpl(UserService userService, UserDao userDao, TokenServise tokenServise, TokenDao tokenDao) {
        this.userService = userService;
        this.userDao = userDao;
        this.tokenServise = tokenServise;
        this.tokenDao = tokenDao;
    }


    @Override
    public Token createToken(User user) {

        String accessToken;

        do {
            accessToken = KeyGenerators.string().generateKey();
        } while (tokenDao.findTokenByAccessToken(accessToken)!=null);

        Date date = new Date();
        Calendar calendar =  Calendar.getInstance();
        calendar.setTime(date);

        calendar.add(Calendar.HOUR, EXPIRE_HOUR);

        Date expires_in = calendar.getTime();

        Token token = new Token(accessToken, expires_in, user);


        return tokenDao.saveAndFlush(token);
    }
}
