package com.charas.account.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestUIController {


    @GetMapping(value = "/hello")
    public ModelAndView hello() {
        return new ModelAndView("hello").addObject("name", "Yashwant");
    }


}
