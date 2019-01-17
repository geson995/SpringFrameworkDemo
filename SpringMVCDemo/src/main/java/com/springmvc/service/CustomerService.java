package com.springmvc.service;

import com.springmvc.entity.Book;
import com.springmvc.entity.Customer;

public interface CustomerService {
    void register(Customer customer);

    Customer login(String username, String pwd);

    void purchaseBook(Book book);

    void recharge(double rechargeNum);
}
