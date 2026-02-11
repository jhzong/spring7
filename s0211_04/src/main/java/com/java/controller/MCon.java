package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.Member;
import com.java.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MCon {

	@Autowired HttpSession session;
	@Autowired MemberService memberService;
	
	@GetMapping("/login")
	public String login(String flag,Model model) {
		model.addAttribute("flag", flag);
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/?flag=0";
	}
	
//	@PostMapping("/login")
//	public String login(String id,String pw,Model model) {
//		System.out.println(id+","+pw);
//		
//		return "login";
//		return "redirect:/";
//	}
	
	@PostMapping("/login")
	public String login(Member member,Model model) {
		System.out.println(member.getId()+","+member.getPw());
		
		//db연결 - 1개는 dto, 여러개면 list
		Member m = memberService.selectIdAndPw(member);
		if(m != null) {
			System.out.println("m : "+m.getId());
			session.setAttribute("session_id", m.getId());
			session.setAttribute("session_name", m.getName());
			return "redirect:/?flag=1";
		}
		else {
			System.out.println("아이디,패스워드 불일치");
		}
		return "redirect:/member/login?flag=2";
	}
}
