package com.hnu.easy_ball.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HWController {
    @RequestMapping("/hello")
    public String hello() {
        return "OJBK";
    }
}
