package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MCon {

	@Autowired //IoC컨테이너에서 객체를 주입
	HttpSession session;
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}

	@GetMapping("/login")
	public String login(Integer flag, Model model) {
		model.addAttribute("flag", flag);
		return "member/login";
	}
	
	@PostMapping("/login")
	public String login(String id, String pw) {
		System.out.println("넘어온 데이터 : "+id+","+pw);
		
		if(id.equals("aaa")&&pw.equals("1111")) {
			session.setAttribute("session_id", id);
			return "redirect:/?flag=1";
		}else {
			return "redirect:/member/login?flag=2";
		}
		
	}
}
