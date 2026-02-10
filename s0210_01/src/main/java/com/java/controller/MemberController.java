package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/member")
	public String member() {
		return "member";
	}
}
