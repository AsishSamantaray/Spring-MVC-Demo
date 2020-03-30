package com.asish.springmvcdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {


    @RequestMapping(value = "/showForm", method = RequestMethod.GET)
    public String showForm() {
        return "helloworld-form";
    }

    // Basic / Simple POST mapping in Spring MVC.
    @RequestMapping(value = "/processForm", method = RequestMethod.POST)
    public String processForm() {
        return "helloworld";
    }
}
