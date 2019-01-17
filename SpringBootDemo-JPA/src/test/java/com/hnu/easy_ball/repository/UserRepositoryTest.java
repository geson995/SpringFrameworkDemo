package com.hnu.easy_ball.repository;

import com.alibaba.fastjson.JSON;
import com.hnu.easy_ball.EasyBallApplication;
import com.hnu.easy_ball.EasyBallApplicationTests;
import com.hnu.easy_ball.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * create by  geson at 2019/1/15 10:23
 * email: pypiguo@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@DataJdbcTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    private TestEntityManager entityManager;

    @Test
    public void test() {


        Assert.assertEquals(1, userRepository.findAll().size());

    }

    @Test
    public void test2() {
        System.out.println(userRepository.findAll().size());
        User jinx = userRepository.findByUserName("jinx");
        jinx.setPassWord("newPWD");
        userRepository.save(jinx);
//        Assert.assertEquals(2, userRepository.findAll().size());
//        Assert.assertEquals("test function findByUsernameOrEmail", "justin", userRepository.findByUserNameOrEmail("geson", null).getNickName());
    }

    @Test
    public void create_time_test() {
        userRepository.save(new User("jinx", "123456", "justin"));
        userRepository.flush();
    }

    @Test
    public void modify_time_test() {
        User geson = userRepository.findByUserName("jinx");
        geson.setPassWord("newPWD");
        userRepository.saveAndFlush(geson);
    }
}