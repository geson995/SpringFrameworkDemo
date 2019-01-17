package com.springmvc.service.impl;

import com.springmvc.dao.CustomerDao;
import com.springmvc.entity.Book;
import com.springmvc.entity.Customer;
import com.springmvc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerDao customerDao;

    @Override
    public void register(Customer customer) {
        customerDao.save(customer);
    }

    @Override
    public Customer login(String username, String pwd) {
        return null;
    }

    @Override
    public void purchaseBook(Book book) {

    }

    @Override
    public void recharge(double rechargeNum) {

    }
}
