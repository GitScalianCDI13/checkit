package com.scalian.checkit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

	@RequestMapping("/user/add")
	public String index(HttpServletRequest request, ModelMap model) {
		

        return "home";
	}
	
}