package com.springmvc.dao.impl;

import com.springmvc.dao.ShopRepository;
import com.springmvc.entity.Book;
import com.springmvc.entity.Customer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/** Created by geson on 2018/9/10. 15:57 */
@Repository("shopRepository")
@Transactional
public class ShopRepositoryImpl implements ShopRepository {
  @Autowired
  private SessionFactory sessionFactory;

  @Autowired
  private HibernateTemplate hibernateTemplate;

  private Session getSession() {
    return sessionFactory.getCurrentSession();
  }

  private HibernateTemplate getHibernateTemplate() {
    return hibernateTemplate;
  }
  /** HQL语句中表名应该是ORM映射的类名,而不是你在数据库中的表名 */
  public Book findBookByBookName(String name) {
    //        String queryPriceSql = "SELECT b.price FROM Book b WHERE b.name = ?";
    //        getSession().beginTransaction();
    Query query = getSession().getNamedQuery("queryBookByName").setString("bookName", name);
    return (Book) query.uniqueResult();
  }

  public void updateBookCount(String name) {
    Query query = getSession().getNamedQuery("queryBookByName").setString("bookName", name);
    int bookCount = ((Book) query.uniqueResult()).getCount();
    if (0 >= bookCount) {
      throw new RuntimeException("库存不足！");
    }
    getSession().getNamedQuery("updateBookCountByName").setString("bookName", name).executeUpdate();
  }

  public void updateUserBalance(String name, float price) {
    float balance =
        (Float)
            getSession()
                .getNamedQuery("queryCustomerBalance")
                .setString("customerName", name)
                .uniqueResult();
    if (0 > balance - price) {
      throw new RuntimeException("余额不足！");
    }
    getSession()
        .getNamedQuery("updateCustomerBalance")
        .setParameter("bookPrice", price)
        .setParameter("customerName", name)
        .executeUpdate();
  }

  public void addCustomer(Customer customer) {
    getHibernateTemplate().save(customer);
    System.out.println("Add a customer!" + customer.getName());
  }

  public List<Customer> getCustomer(String name) {
    return (List<Customer>)
        getHibernateTemplate()
            .findByNamedQueryAndNamedParam("queryCustomersByName", "customerName", name);
    //     return (List<Customer>) getHibernateTemplate().find("from Customer c where c.name =
    // ?",name);
  }

  @Override
  public List<Customer> getCustomers() {
    return null;
  }

  public List<Customer> getCustomers(String name) {
    return (List<Customer>) getHibernateTemplate().find("from Customer");
  }

  public void recharge(Customer customer, Float cash) {
    Float balance = customer.getBalance();
    customer.setBalance(balance + cash);
    getHibernateTemplate().update(customer);
  }

  public void addBooks(List<Book> bookList) {
    for (Book book : bookList) {
      getHibernateTemplate().save(book);
      System.out.println("Add a Book" + book.getName());
    }
  }
}
