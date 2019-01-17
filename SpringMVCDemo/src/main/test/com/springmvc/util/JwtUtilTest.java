package com.springmvc.util;

import com.springmvc.dao.CustomerDao;
import com.springmvc.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * @Author: geson
 * @Date:2019/1/8 14:28
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class JwtUtilTest {
    @Autowired
    CustomerDao customerDao;
    private static final Logger logger = LoggerFactory.getLogger(JwtUtilTest.class);

    @Test
    public void test() throws Exception {
        Customer customer = customerDao.findByUsername("jinx");
        String token = JwtUtil.createJWT(customer);
        logger.info(token);
        assertEquals("test parse uid from token", customer.getId(), JwtUtil.parseJWT(token));

    }

}