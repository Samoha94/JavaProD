package com.gmail.samoha199412.services;

import com.gmail.samoha199412.entities.token.Token;
import com.gmail.samoha199412.entities.user.User;

public interface UserService {

    Token registerNewUser(User user);
    User createNewUser(User user);

}
