package com.springmvc.service.impl;

import com.springmvc.dao.ShopRepository;
import com.springmvc.entity.Book;
import com.springmvc.entity.Customer;
import com.springmvc.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** Created by geson on 2018/9/10. 13:10 */
@Service("shopService")
public class ShopServiceImpl implements ShopService {
  @Autowired
  private ShopRepository shopRepository;

  public void buyBook(String userName, String bookName) {
    float price = shopRepository.findBookByBookName(bookName).getPrice();
    shopRepository.updateBookCount(bookName);
    shopRepository.updateUserBalance(userName, price);
  }

  public void addCustomerOrRecharge(String userName, Float cash) {
    List<Customer> customers = shopRepository.getCustomer(userName);
    if (customers.isEmpty()) {
      System.out.println("No Such Customer,NEW one!");
      Customer customer = new Customer(userName, cash);
      shopRepository.addCustomer(customer);
    } else {
      shopRepository.recharge(customers.get(0), cash);
      System.out.println("Success to Recharge");
    }
  }

  public void addBooks(List<Book> bookList) {
    shopRepository.addBooks(bookList);
  }

  @Override
  public List<Customer> getAllCustomers() {
    return shopRepository.getCustomers();
  }

  @Override
  public List<Book> showAllBooks() {
    return null;
  }

}
