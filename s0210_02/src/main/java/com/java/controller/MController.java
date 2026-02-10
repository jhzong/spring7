package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.dto.MemberDto;

@Controller
public class MController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/doLogin")
	public String doLogin(MemberDto mdto, Model model) {
		model.addAttribute("member", mdto);
		return "doLogin";
	}
	
	@GetMapping("/join")
	public String join() {
		return "join";
	}
	
	@PostMapping("/doJoin")
	public String doJoin(MemberDto mdto, Model model) {
		System.out.println(String.format("%s, %s, %s, %s, %s, %s, %s",
				mdto.getId(),mdto.getPw(),mdto.getName(),mdto.getPhone(),
				mdto.getEmail(),mdto.getGender(),mdto.getHobby()));
		model.addAttribute("member", mdto);
		return "doJoin";
	}
}
