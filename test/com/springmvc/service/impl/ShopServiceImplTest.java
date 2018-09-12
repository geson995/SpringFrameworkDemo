package com.springmvc.service.impl;

import com.alibaba.fastjson.JSON;
import com.springmvc.dao.ShopRepository;
import com.springmvc.entity.Book;
import com.springmvc.service.ShopService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by geson on 2018/9/10.
 * 14:45
 */
public class ShopServiceImplTest {
    private ApplicationContext context = null;
    private ShopService shopService = null;
    private ShopRepository shopRepository = null;

    {
        context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        shopService = context.getBean(ShopService.class);
        shopRepository = context.getBean(ShopRepository.class);
    }

    @Test
    public void initMethod() {
        List<Book> bookList = new ArrayList<Book>() {{
            add(new Book("Java", Float.valueOf("3.5"), 10));
            add(new Book("C", new Float("3"), 10));
        }};
        shopService.addBooks(bookList);
        shopService.addCustomerOrRecharge("jayjay",Float.valueOf(100));
    }

    @Test
    public void testMethod(){
        shopService.addCustomerOrRecharge("geson",Float.valueOf(100));
    }
    @Test
    public void test1() {
        shopService.buyBook("jayjay", "Java");
    }

    @Test
    public void test3() {
        System.out.println(JSON.toJSONString(shopRepository.findBookByBookName("java")));
    }
}