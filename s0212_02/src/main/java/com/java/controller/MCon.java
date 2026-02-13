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
	
	@GetMapping("/login")//로그인페이지
	public String login(String flag, Model model) {
		model.addAttribute("flag", flag);
		return "login";
	}
	
	@PostMapping("/login")//로그인확인
	public String login(MemberDto mDto) {
		MemberDto m = memberService.selectIdAndPw(mDto);
		
		if(m != null) {
			session.setAttribute("session_id", m.getId());
			session.setAttribute("session_name", m.getName());
			return "redirect:/?flag=1";
		}else {
			return"redirect:/member/login?flag=2";
		}
	}
	
	@GetMapping("/logout")//로그아웃
	public String logout() {
		session.invalidate();
		return "redirect:/?flag=0";
	}
	
	@GetMapping("/mlist")//회원전체목록 불러오기List
	public String mlist(Model model) {
		List<MemberDto> list = memberService.selectAllMem();
		System.out.println("list 개수 : "+list.size());
		model.addAttribute("list", list);
		return"mlist";
	}
	
	@GetMapping("/join01")//회원가입(약관동의)
	public String join01() {
		return "join01";
	}
	
	@GetMapping("/join02")//회원가입(회원정보)
	public String join02() {
		return "join02";
	}
	
	@PostMapping("/join03")//회원가입(회원정보)-입력/저장
	public String join03(MemberDto mDto) {
		System.out.println(mDto);
		return "join03";
	}
	
	
}
