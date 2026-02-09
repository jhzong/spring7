package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.Getter;

@Controller//모든 url주소는 controller주소로 들어온다.
@Getter
public class FrontController {

//	Product product = new TV(); ←기존 객체선언 방식
	@Autowired
	Product product;
	
	@GetMapping("/index")// http://localhost:8181/index
	public String index() {
		System.out.println("스프링 자동 di : "+product.getName());
		TV2 tv2 = new TV2();
		System.out.println("객체선언 : "+tv2.getName());
		
		Member member = new Member();
		member.setId("aaa");
		System.out.println(member.getId());
		member.setPw("1111");
		System.out.println(member.getPw());
		
		return "index";
	}
	
	@GetMapping("/member")// http://localhost:8181/member
	public String member() {
		System.out.println("test member");
		return "member";
	}
}
