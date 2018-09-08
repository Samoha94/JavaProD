package com.gmail.samoha199412.dao.token;

import com.gmail.samoha199412.entities.token.Token;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TokenDao extends JpaRepository<Token, Long> {

    Token findTokenByAccessToken(String acessToken);


}
