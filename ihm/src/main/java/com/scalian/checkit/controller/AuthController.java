package com.scalian.checkit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthController {
	
	@RequestMapping("/auth")
	public String auth(ModelMap model) {
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request, ModelMap model) {
		request.setAttribute("param1", "foo");
        request.setAttribute("param2", "bar");
        return "redirect:/home";
	}
}
