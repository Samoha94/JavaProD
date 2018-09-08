package com.gmail.samoha199412.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "user ulready exist")
public class UserAlreadyExsist extends Exception {

    public UserAlreadyExsist(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }


    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }
}
