package com.scalian.checkit.controller;

import com.scalian.checkit.service.impl.TestBU;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {

    @Autowired
    TestBU testBU;

    @RequestMapping("/test/list")
    public String list(HttpServletRequest request, ModelMap model) {
        model.addAttribute("list", testBU.findAll());
        return "test_list";
    }
}
