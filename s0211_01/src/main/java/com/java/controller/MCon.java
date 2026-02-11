package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MCon {

	@Autowired MemberService memberService;
	@Autowired HttpSession session;
	
	@GetMapping("/login")
	public String login(Integer flag, Model model) {//로그인페이지 띄우기
		model.addAttribute("flag", flag);
		return "login";
	}
	
	@PostMapping("/login")
	public String login(String id, String pw) {//로그인하기
		System.out.println("입력된 ID : "+id+", 입력된 PW : "+pw);

		if(id.equals("aaa")&&pw.equals("1111")) {
			session.setAttribute("session_id", id);
			return "redirect:/?flag=1";
		}else {
			return "redirect:/member/login?flag=2";
		}
		
	}
	
	@GetMapping("/logout")
	public String logout() {//로그아웃하기
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/mlist")
	public String mlist(Model model) {//member 받아 mlist에 출력
		List<MemberDto> list = memberService.memberSelectAll();
		model.addAttribute("list", list);
		System.out.println("list개수 : "+list.size());
		return "mlist";
	}
}
