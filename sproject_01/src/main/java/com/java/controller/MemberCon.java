package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberCon {
	
	@Autowired MemberService memberService;
	@Autowired HttpSession session;

	//1.로그인페이지 연결
	@GetMapping("/member/login")
	public String login() {
		return "member/login";
	}

	//2.로그인하기(아이디,비번 확인)
	@PostMapping("/member/login")
	public String login(MemberDto mdto, 
			@RequestParam(name = "idsave",required = false) String idsave,
			HttpServletResponse response, Model model) {
		//입력된 아이디 쿠키저장
		Cookie cookie = new Cookie("cook_id", mdto.getId());
		cookie.setPath("/");
		if (idsave!=null) cookie.setMaxAge(60*60*24*30);//30일(60초*60분*24시간*30일)
		else cookie.setMaxAge(0);
		response.addCookie(cookie);
		
		MemberDto memberDto = memberService.findByIdAndPw(mdto);
		if (memberDto!=null) {
			session.setAttribute("session_id",mdto.getId());
			session.setAttribute("session_name",mdto.getName());
			model.addAttribute("flag", 1);
		}else {
			model.addAttribute("flag", -1);
		}
		return "member/login";
	}
	
	//3.로그아웃하기
	@GetMapping("/member/logout")
	public String logout(Model model) {
		session.invalidate();
		model.addAttribute("flag", 0);
		return "member/login";
	}
	
	//4.회원가입페이지 연결(step01)
	@GetMapping("/member/step01")
	public String step01(Model model) {
		
		return "member/step01";
	}
	
	//5.회원가입페이지 연결(step02)
	@GetMapping("/member/step02")
	public String step02(Model model) {
		
		return "member/step02";
	}
	
	//6.회원가입페이지 연결(step03)
	@GetMapping("/member/step03")
	public String step03(Model model) {
		
		return "member/step03";
	}
	
	//7.회원데이터 저장(가입)
	@PostMapping("/member/step03")
	public String step03(MemberDto mdto,
			@RequestParam(name = "phone1",required = false) String phone1,
			@RequestParam(name = "phone2",required = false) String phone2,
			@RequestParam(name = "phone3",required = false) String phone3,
			@RequestParam(name = "email1",required = false) String email1,
			@RequestParam(name = "email2",required = false) String email2,
			Model model) {
			String phone = phone1+","+phone2+","+phone3;
			String email = email1+"@"+email2;
			mdto.setPhone(phone);
			mdto.setEmail(email);
			
			//service로 전달
			memberService.save(mdto);
		return "redirect:/member/step04?id="+mdto.getId();
	}
	
	//7-1.아이디 중복확인
	@ResponseBody
	@GetMapping("/member/idCheck")
	public String idCheck(MemberDto mdto) {
		String id = mdto.getId();
		System.out.println("id : "+id);
		//DB 확인
		String temp = "able";
		MemberDto memberDto = memberService.findById(id);
		if (memberDto!=null) temp="unable";
		return temp;
	}
	
	//8.회원가입페이지 연결(step04)
	@GetMapping("/member/step04")
	public String step04(
			@RequestParam(name = "id",required = false) String id,
			Model model) {
		model.addAttribute("id", id);
		return "member/step04";
	}
}
