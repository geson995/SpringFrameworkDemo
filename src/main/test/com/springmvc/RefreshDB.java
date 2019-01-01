package com.springmvc;

import com.springmvc.entity.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class RefreshDB {
    @Autowired
    HibernateTemplate hibernateTemplate;

    @Test
    public void refresh() {
        System.out.println("*******refresh hibernate configure inject!******");
    }

    @Test
    public void initData() {
        Category category = new Category("计算机");
        hibernateTemplate.save(category);
    }
}
