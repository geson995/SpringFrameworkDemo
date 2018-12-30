package com.springmvc.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

//@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:SpringMVC-servlet.xml"})
//@ContextHierarchy({
//        @ContextConfiguration(locations = "classpath:applicationContext.xml"),
//        @ContextConfiguration(locations = "classpath:SpringMVC-servlet.xml")
//})
public class ShopControllerTest {
    @Autowired
    private WebApplicationContext waCtx;
    private MockMvc mockMvc;

//    @Before
//    public void setUp() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver(); //重新配置视图解析器避免 Circular view path
//        resolver.setPrefix("/WEB_INF/views");
//        resolver.setSuffix(".jsp");
//        mockMvc = MockMvcBuilders.standaloneSetup(new ShopController()).build();
//    }

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(waCtx).build();
    }


    @Test
    public void pureJson() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/book_store/test3.do").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void getViewWithParam() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/book_store/test/{customerName}", String.valueOf("apple")))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("home"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void injectedTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/book_store/testJson").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/book_store/customerInfos.do"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}