package com.hnu.easy_ball.repository;

import com.hnu.easy_ball.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * create by  geson at 2019/1/15 9:43
 * email: pypiguo@gmail.com
 */
public interface UserRepository extends JpaRepository<User, String> {
    User findByUserName(String userName);

    User findByUserNameOrEmail(String userName, String email);

}
