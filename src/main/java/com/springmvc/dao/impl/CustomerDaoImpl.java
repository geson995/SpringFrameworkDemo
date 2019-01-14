package com.springmvc.dao.impl;

import com.springmvc.dao.CustomerDao;
import com.springmvc.dao.common.AbstractHibernateDao;
import com.springmvc.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CustomerDaoImpl extends AbstractHibernateDao<Customer, String> implements CustomerDao {
    private static final Logger logger = LoggerFactory.getLogger(CustomerDaoImpl.class);

    public CustomerDaoImpl() {
        super();
        setClazz(Customer.class);
    }

    @Override
    public Customer findByUsername(String username) throws Exception {
        List<Customer> targetCustomers = getCurrentSession()
                .createQuery("from Customer c where c.username = :username", Customer.class)
                .setParameter("username", username)
                .getResultList();
        if (targetCustomers.isEmpty())
            throw new Exception("No Such Person");
        return targetCustomers.get(0);
    }
}
