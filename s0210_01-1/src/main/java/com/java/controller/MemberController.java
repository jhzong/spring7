package com.java.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.dto.MemberDto;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MemberController {

	@GetMapping("/login")
	public String login(Integer flag, Model model) {
		System.out.println("flag : "+flag);
		model.addAttribute("flag", flag);
		return "login";
	}
	
	@PostMapping("/doLogin")
	public String doLogin(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if(id.equals("aaa")&&pw.equals("1111")) {
			return "redirect:/?flag=1";
		}else {
			return "redirect:/login?flag=2";
		}
		
//		model.addAttribute("id", id);
//		model.addAttribute("pw", pw);
//		return "doLogin";
	}
	
	@GetMapping("/join")
	public String join() {
		return "join";
	}
	
	@GetMapping("/mUpdate")
	public String mUpdate(Model model) {
		MemberDto mdto = new MemberDto("aaa", "1111", "홍길동", "010-1111-1111", "aaa@naver.com", "여자", "게임,골프,독서");
		model.addAttribute("member", mdto);
		return "mUpdate";
	}
	
	@PostMapping("/doJoin")
	public String doJoin(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String[] hobby = request.getParameterValues("hobby");
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("name", name);
		model.addAttribute("phone", phone);
		model.addAttribute("email", email);
		model.addAttribute("gender", gender);
		model.addAttribute("hobby", hobby);
		
		System.out.println(String.format("%s, %s, %s, %s, %s, %s, %s",id, pw, name, phone, email, gender, hobby));
		return "doJoin";
	}
}
