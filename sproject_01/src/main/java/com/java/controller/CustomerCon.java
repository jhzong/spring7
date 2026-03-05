package com.java.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.BoardDto;
import com.java.service.CustomerService;

@Controller
public class CustomerCon {
	
	@Autowired CustomerService customerService;

	@GetMapping("/customer/customerWrite")
	public String customerWrite() {

		return "customer/customerWrite";
	}
	
	@GetMapping("/customer/customer")
	public String customer(
			@RequestParam(name = "page",defaultValue = "1") int page,
			@RequestParam(name = "size",defaultValue = "10") int size,
			@RequestParam(name = "category",required = false) String category,
			@RequestParam(name = "search",required = false) String search,
			Model model) {
//		List<BoardDto> list = customerService.findAll();
		Map<String, Object> map = customerService.findAll(page,size,category,search);
		model.addAttribute("map", map);
		return "customer/customer";
	}
}
