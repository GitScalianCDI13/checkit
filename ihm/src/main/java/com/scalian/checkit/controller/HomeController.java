package com.scalian.checkit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String index(HttpServletRequest request) {
		
		//request.setAttribute("param1", "foo");
        //request.setAttribute("param2", "bar");
        return "home";
	}
	
}
