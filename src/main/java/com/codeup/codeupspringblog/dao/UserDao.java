package com.codeup.codeupspringblog.dao;

// make sure import statement is correct when calling "User" because there may be many pre-existing User classes
import com.codeup.codeupspringblog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

    //override the method to return the user
    User findUserById(long id);
}
