package com.springmvc.controller;

import com.springmvc.dao.ShopRepository;
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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/** Created by geson on 2018/9/10. 12:21 */
@Controller
@RequestMapping("/book_store")
public class ShopController {
  private final Logger LOGGER = LoggerFactory.getLogger(ShopController.class);
  @Autowired private ShopService shopService;
  @Autowired private ShopRepository shopRepository;

  @RequestMapping("/test/{customerName}")
  public String testMethod(@PathVariable(value = "customerName") String customerName, Model model) {
    System.out.println("start testMethod!");
    LOGGER.info(customerName + " buy a book From Logger");
    shopService.buyBook(customerName, "java");
    model.addAttribute("customerName", customerName);
    return "home";
  }

  @RequestMapping("/customerInfos")
  public String customerInfos(ModelMap modelMap) {
    List<Customer> customerList = shopService.getAllCustomers();
    modelMap.addAttribute("customerList", customerList);
    return "customerInfos";
  }

  @RequestMapping(name = "purchaseBook", method = RequestMethod.POST)
  public String purchaseBook(ModelMap modelMap, String customerName, String bookName) {
    shopService.buyBook(customerName, bookName);
    modelMap.addAttribute("customerName", customerName);
    modelMap.addAttribute("bookName", bookName);
    return "customerInfo";
  }

  @RequestMapping(name = "bookInfo/{bookName}", method = RequestMethod.GET)
  public ModelAndView queryBookInfoByName(
          HttpServletRequest request, @PathVariable(value = "bookName") String bookName) {
    Book book = shopRepository.findBookByBookName(bookName);
    ModelAndView modelAndView = new ModelAndView("bookInfo");
    modelAndView.addObject("bookModel", book);
    return modelAndView;
  }
}
