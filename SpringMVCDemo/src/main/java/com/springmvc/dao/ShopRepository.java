package com.springmvc.dao;

import com.springmvc.entity.Book;
import com.springmvc.entity.Customer;

import java.util.List;

/** Created by geson on 2018/9/10. 15:56 */
public interface ShopRepository {
  public Book findBookByBookName(String name);

  public void updateBookCount(String name);

  public void updateUserBalance(String name, float price);

  public void addBooks(List<Book> bookList);

  public void addCustomer(Customer customer);

  public List<Customer> getCustomer(String userName);

  public List<Customer> getCustomers();

  public void recharge(Customer customer, Float cash);
}
