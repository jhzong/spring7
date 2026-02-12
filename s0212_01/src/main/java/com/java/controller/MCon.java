package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MCon {

	@Autowired MemberService memberService;
	@Autowired HttpSession session;
	
	// 1.회원가입(약관동의)페이지 호출
	@GetMapping("/join01")
	public String join01() {
		return "join01";
	}
	
	// 2.회원가입(회원정보)페이지 호출
	@GetMapping("/join02")
	public String join02() {
		return "join02";
	}
	
	// 3.회원가입(가입완료)페이지 호출-phone1,2,3 & email1,2
	@PostMapping("/join03")
	public String join03(MemberDto mdto,
			String phone1,String phone2,String phone3,
			String email1,String email2,
			Model model
			) {

		String phone = String.format("%s-%s-%s", phone1, phone2, phone3);
		String email = String.format("%s@%s", email1, email2);
		mdto.setPhone(phone);
		mdto.setEmail(email);
		
		//DB저장
		memberService.insertMember(mdto);
		
		return "join03";
	}
	
	// 로그인페이지 호출
	@GetMapping("/login")
	public String login(String flag,Model model) {
		model.addAttribute("flag", flag);
		return "login";
	}
	
	// 로그인 확인 - session,cookie 저장
	@PostMapping("/login")
	public String login(MemberDto mDto, String saveId,
			HttpServletResponse response) {
		// System.out.println(mDto.getId()+","+mDto.getPw());
		System.out.println("saveID : "+saveId);
		// cookie에 아이디저장
		Cookie cookie = new Cookie("cook_id",mDto.getId());
		if(saveId!=null) {
			cookie.setMaxAge(60*60*24*30);
		}else {
			cookie.setMaxAge(0);
		}
		response.addCookie(cookie);
		
		MemberDto memberDto = memberService.selectLogin(mDto);
		if(memberDto != null) {
//			System.out.println("id,pw일치\n"+memberDto.getId()+","+memberDto.getPw());
			session.setAttribute("session_id", memberDto.getId());
			session.setAttribute("session_name", memberDto.getName());
			return "redirect:/?flag=1";
		}else {
//			System.out.println("id,pw불일치");
			return "redirect:/member/login?flag=2";
		}
	}
	
	// 로그아웃
	@GetMapping("/logout")
	public String logout(String flag,Model model) {
		model.addAttribute("flag", flag);
		session.invalidate();
		return "redirect:/?flag=0";
	}
}
