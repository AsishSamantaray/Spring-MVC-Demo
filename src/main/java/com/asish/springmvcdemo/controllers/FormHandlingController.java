package com.asish.springmvcdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FormHandlingController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showForm() {
        return "simple-form";
    }

    // (Option-1) To handle form data and Convert the Form value to uppercase.
    @RequestMapping(value = "/processFormV1", method = RequestMethod.POST)
    public String processFormV1(HttpServletRequest req, Model model) {
        // Model is an Interface works as a container that contains the data of our application..
        String name = req.getParameter("name");
        String uName = name.toUpperCase();
        model.addAttribute("uName", uName);
        return "helloworld";
    }

    // (Option-2) To handle form data and Convert the Form value to uppercase. (Using Model Interface)
    @PostMapping("/processFormV2")
    public String processFormV2(@RequestParam String name, Model model) {
        // Model interface act as a container that contains data of our application..
        String uName = name.toUpperCase();
        model.addAttribute("uName", uName);
        return "helloworld";
    }

    // (Option-3) To handle form data and Convert the Form value to uppercase. (Using ModelMap class)
    @RequestMapping(value = "/processFormV3", method = RequestMethod.POST)
    public String processFormV3(@RequestParam String name, ModelMap modelMap) {
        String uName = name.toUpperCase();
        modelMap.addAttribute("uName", uName);
        return "helloworld";
    }

    // (Option-4) To handle form data and Convert the Form value to uppercase. (Using ModelAndView class)
    @RequestMapping(value = "/processFormV4", method = RequestMethod.POST)
    public ModelAndView processFormV4(@RequestParam String name, ModelAndView modelAndView) {
        String uName = name.toUpperCase();
        modelAndView.addObject("uName", uName);
        modelAndView.setViewName("helloworld");
        return modelAndView;
    }

}
