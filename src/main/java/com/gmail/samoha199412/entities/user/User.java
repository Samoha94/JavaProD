package com.gmail.samoha199412.entities.user;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gmail.samoha199412.converter.BooleanToStringConverter;
import com.gmail.samoha199412.entities.UserFiles.UserFile;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Builder
@ToString
@Entity
@Table(name = "users")
public class User implements UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private boolean enabled;


    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;


    @OneToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private List<UserFile> userFiles;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @JsonIgnore
    private List<Role> authorities;

    @JsonProperty(value = "name")
    private String username;

    @Convert(converter= BooleanToStringConverter.class)
    @Column(name = "account_non_expired", nullable = false, length = 1)
    @JsonIgnore
    private boolean accountNonExpired;

    @Convert(converter=BooleanToStringConverter.class)
    @Column(name = "account_non_locked", nullable = false, length = 1)
    @JsonIgnore
    private boolean accountNonLocked;

    @Convert(converter=BooleanToStringConverter.class)
    @Column(name = "credentials_non_expired", nullable = false, length = 1)
    @JsonIgnore
    private boolean credentialsNonExpired;

}
