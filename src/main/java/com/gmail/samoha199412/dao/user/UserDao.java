package com.gmail.samoha199412.dao.user;

import com.gmail.samoha199412.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {



}
