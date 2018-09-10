package com.springmvc.service;

import com.springmvc.entity.Book;
import com.springmvc.entity.Customer;

import java.util.List;

/**
 * Created by geson on 2018/9/10.
 * 13:09
 */
public interface ShopService {
    public void buyBook(String userName,String bookName);
    public void addCustomerOrRecharge(String userName, Float cash);
    public void addBooks(List<Book> bookList);
    public List<Customer> getAllCustomers();
    public List<Book> showAllBooks();

}
