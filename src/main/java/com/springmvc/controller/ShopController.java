package com.springmvc.controller;

import com.alibaba.fastjson.JSON;
import com.springmvc.entity.Book;
import com.springmvc.entity.Customer;
import com.springmvc.service.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by geson on 2018/9/10. 12:21
 */
@Controller
@RequestMapping("/book_store")
public class ShopController {
    private final Logger LOGGER = LoggerFactory.getLogger(ShopController.class);
    @Autowired
    private ShopService shopService;

    @RequestMapping("/test/{customerName}")
    public String testMethod(@PathVariable(value = "customerName") String customerName, Model model) {
        System.out.println("start testMethod!");
        LOGGER.info(customerName + " buy a book From Logger");
        //    shopService.buyBook(customerName, "java");
        model.addAttribute("customerName", customerName);
        return "home";
    }

    @RequestMapping("/customerInfos")
    public String customerInfos(ModelMap modelMap) {
        List<Customer> customerList = shopService.getAllCustomers();
        modelMap.addAttribute("customerList", customerList);
        LOGGER.info(JSON.toJSONString(customerList));
        return "customerInfos";
    }

    @RequestMapping("/testJson")
    @ResponseBody
    public List customerInfosJson() {
        return shopService.getAllCustomers();
    }

    @RequestMapping(value = "/test3.do",method = RequestMethod.POST)
    @ResponseBody
    public List<String> test3() {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        return list;
    }
    @RequestMapping(value = "/test3.do",method = RequestMethod.GET)
    @ResponseBody
    public List<String> test2() {
        List<String> list = new ArrayList<>();
        list.add("ggg");
        list.add("jjj");
        return list;
    }

    @RequestMapping(value = "/purchaseBook", method = RequestMethod.POST)
    public String purchaseBook(ModelMap modelMap, String customerName, String bookName) {
        shopService.buyBook(customerName, bookName);
        modelMap.addAttribute("customerName", customerName);
        modelMap.addAttribute("bookName", bookName);
        /*
         *TODO hibernate表关联
         *关联customer表和book表，展示购买记录
         **/
        return "customerInfo";
    }

    @RequestMapping(value = "/bookInfo/{bookName}", method = RequestMethod.GET)
    public ModelAndView queryBookInfoByName(@PathVariable(value = "bookName") String bookName) {
        ModelAndView modelAndView = new ModelAndView("bookInfo");
        Book book;
        boolean hasThisBook = true;
        try {
            System.out.println(bookName);
            book = shopService.findBookByName(bookName);
            LOGGER.info(JSON.toJSONString(book));
            modelAndView.addObject("bookModel", book);
            modelAndView.addObject("bookName", bookName);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("No Such BookName");
            hasThisBook = false;
        }
        modelAndView.addObject("hasBook", hasThisBook);
        return modelAndView;
    }

    @RequestMapping("/recharge")
    public String rechargeCustomer(String customerName, float rechargeNum, Model model) {
        shopService.addCustomerOrRecharge(customerName, rechargeNum);
        List<Customer> customerList = shopService.getAllCustomers();
        model.addAttribute("customerList", customerList);
        return "customerInfos";
    }

}
