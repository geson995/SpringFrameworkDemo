package com.springmvc.dao;

import com.alibaba.fastjson.JSON;
import com.springmvc.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CustomerDaoTest {
    @Autowired
    CustomerDao customerDao;

    //    @Test(expected = Exception.class)
    @Test
    public void findByUsername() throws Exception {
        try {
            Customer customer = customerDao.findByUsername("jinx22");
            //        Customer customer = customerDao.findOne("40284881680e3b4401680e3b4ca10000");
            System.out.println(JSON.toJSONString(customer));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}