package com.springmvc.dao.impl;

import com.springmvc.dao.ShopRepository;
import com.springmvc.entity.Book;
import com.springmvc.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by geson on 2018/9/10. 15:57
 */
@Repository("shopRepository")
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

    /**
     * HQL语句中表名应该是ORM映射的类名,而不是你在数据库中的表名
     */
    public Book findBookByBookName(String name) {
        //        String queryPriceSql = "SELECT b.price FROM Book b WHERE b.name = ?";
        return (Book) getHibernateTemplate().find("select b from Book b where b.name = ?", name).get(0);
        //        getSession().beginTransaction();
//    Query query = getSession().getNamedQuery("queryBookByName").setString("bookName", name);
//    return (Book) query.uniqueResult();
    }

    public void updateBookCount(String name) {
        Query query = getSession().getNamedQuery("queryBookByName").setParameter("bookName", name);
        int bookCount = ((Book) query.uniqueResult()).getCount();
        if (0 >= bookCount) {
            throw new RuntimeException("库存不足！");
        }
        getSession().getNamedQuery("updateBookCountByName").setParameter("bookName", name).executeUpdate();
    }

    public void updateUserBalance(String name, float price) {
        float balance =
                (Float)
                        getSession()
                                .getNamedQuery("queryCustomerBalance")
                                .setParameter("customerName", name)
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

    public List<Customer> getCustomers() {
        return (List<Customer>) getHibernateTemplate().findByNamedQuery("queryCustomers");
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
