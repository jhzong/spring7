package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FCon {

	@GetMapping({"/","/index","/main"})
	public String index() {
		return "index";
	}
}
