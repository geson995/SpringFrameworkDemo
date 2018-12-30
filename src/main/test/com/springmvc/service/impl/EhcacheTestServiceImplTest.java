package com.springmvc.service.impl;

import com.springmvc.service.EhcacheTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class EhcacheTestServiceImplTest {
    @Autowired
    private EhcacheTestService ehcacheTestService;

    @Test
    public void test() throws InterruptedException {
        String firstRec = ehcacheTestService.getTimestamp("param");
        System.out.println("第一次调用：" + firstRec);

        Thread.sleep(2000);
        String secondRec = ehcacheTestService.getTimestamp("param");
        System.out.println("2秒之后调用：" + secondRec);
        assertEquals("两秒内同param缓存一致", firstRec, secondRec);

        Thread.sleep(2000);
        String thirdRec = ehcacheTestService.getTimestamp("newParam");
        System.out.println("2秒之后调用(with another param)：" + thirdRec);
        assertNotEquals("有效期10s内,不同param缓存不一致", firstRec, thirdRec);

        Thread.sleep(2000);
        String forthRec = ehcacheTestService.getTimestamp("newParam");
        System.out.println("2秒之后调用(with the second param)：" + forthRec);
        assertEquals(thirdRec, forthRec);

        Thread.sleep(2000);
        String fifthRec = ehcacheTestService.getTimestamp("param");
        System.out.println("2秒之后调用(with the first param)：" + fifthRec);
        assertEquals(firstRec, fifthRec);

        Thread.sleep(11000);
        String sixthRec = ehcacheTestService.getTimestamp("param");
        System.out.println("缓存idle期为10s,11秒之后调用(with the first param)：" + sixthRec);
        assertNotEquals("缓存等待10s后清楚", fifthRec, sixthRec);

        Thread.sleep(9000);
        System.out.println("缓存live期为20s,9秒之后调用(with the first param)：" + ehcacheTestService.getTimestamp("param"));
        Thread.sleep(9000);
        System.out.println("缓存live期为20s,9秒之后调用(with the first param)：" + ehcacheTestService.getTimestamp("param"));

        Thread.sleep(9000);
        String seventhRec = ehcacheTestService.getTimestamp("param");
        System.out.println("缓存live期为20s,9秒之后调用(with the first param)：" + secondRec);
        assertNotEquals("缓存最多续命20s", sixthRec, seventhRec);
    }

}