package com.gmail.samoha199412.entities.token;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gmail.samoha199412.entities.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@ToString
@Entity
@Table(name = "Token")
@AllArgsConstructor
@NoArgsConstructor
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "access_token")
    private String accessToken;


    @Column(name = "expires_in")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiresIn;

    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Token(String accessToken, Date expiresIn, User user){
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.user = user;
    }


}
