package com.springmvc;

import com.springmvc.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class RefreshDB {
    @Autowired
    HibernateTemplate hibernateTemplate;
    @Autowired
    SessionFactory sessionFactory;

    @Test
    public void refresh() {
        System.out.println("*******refresh hibernate configure inject!******");
    }

    @Test
    public void initData() {
//        Category category = new Category("Science");
//        hibernateTemplate.save(category);
//        hibernateTemplate.save(new Category("Nature"));
        Customer customer = new Customer("newPerson3", Float.valueOf(200));
//        Logger LOGGER = LoggerFactory.getLogger(RefreshDB.class);
//        LOGGER.info(JSON.toJSONString(customer));
        customer.setCreateTime(new Timestamp(System.currentTimeMillis()));
//        hibernateTemplate.save(customer);
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.persist(customer);
        transaction.commit();
        session.close();
//
//        Session session = sessionFactory.getCurrentSession();
    }
}
