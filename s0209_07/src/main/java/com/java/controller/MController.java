package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MController {

	@GetMapping("/login")
	public String login() {
		System.out.println("<logging in>");
		return "member/login";
	}
	
	@PostMapping("/doLogin")
	public String doLogin() {
		System.out.println("<confirming>");
		return "member/doLogin";
	}
	
	@GetMapping("/logout")
	public String logout() {
		System.out.println("<logging out>");
		return "member/logout";
	}
}
