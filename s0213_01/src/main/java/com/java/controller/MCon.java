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
	
	@PostMapping("/mupdate")//회원정보확인 및 수정
	public String mupdate(MemberDto mDto,
			String phone1, String phone2, String phone3,
			String email1, String email2, Model model) {
		String id = (String)session.getAttribute("session_id");
		mDto.setId(id);
		
		//패스워드 확인
		MemberDto memberDto = memberService.selectOne(id);
		if(!memberDto.getPw().equals(mDto.getPw())) {
			System.out.println("잘못된 패스워드");
			return "redirect:/?flag=4";
		}
		
		String phone = phone1+"-"+phone2+"-"+phone3;
		String email = email1+"@"+email2;
		mDto.setPhone(phone);
		mDto.setEmail(email);
		//DB수정
		memberService.updateMember(mDto);
		System.out.println("mupdate id : "+id);
		return "redirect:/?flag=3";
	}//회원정보확인 및 수정
	
	@GetMapping("/mupdate")//mupdate페이지 호출
	public String mupdate(Model model) {
		String id = (String)session.getAttribute("session_id");
		MemberDto memberDto = memberService.selectOne(id);
		model.addAttribute("member", memberDto);
		System.out.println("mupdate id : "+id);
		return "member/mupdate";
	}//mupdate페이지 호출
	
	@GetMapping("/login")//login페이지 호출
	public String login(String flag, Model model) {
		model.addAttribute("flag", flag);
		return "member/login";
	}//login페이지 호출
	
	@PostMapping("/login")//login확인
	public String login(MemberDto mDto,String saveId,
			HttpServletResponse response,
			Model model) {
		System.out.println("id : "+mDto.getId()+", pw : "+mDto.getPw());
		//saveId쿠키저장
		Cookie cookie = new Cookie("cook_id", mDto.getId());
		if(saveId != null) cookie.setMaxAge(60*60*24*30);
		else cookie.setMaxAge(0);
		response.addCookie(cookie);
		
		//login확인부분
		MemberDto m = memberService.selectIdAndPw(mDto);
		if(m != null) {
			session.setAttribute("session_id", m.getId());
			session.setAttribute("session_name", m.getName());
			return "redirect:/?flag=1";
		}else {
			return "redirect:/member/login?flag=2";
		}
	}//login확인
	
	@GetMapping("/logout")//logout
	public String logout(String flag, Model model) {
		model.addAttribute("flag", flag);
		session.invalidate();
		return "redirect:/?flag=0";
	}//logout
	
	@GetMapping("/join01")//join01페이지(약관동의) 호출
	public String join01() {
		return "member/join01";
	}//join01페이지(약관동의) 호출
	
	@GetMapping("/join02")//join02페이지(회원정보) 호출
	public String join02() {
		return "member/join02";
	}//join02페이지(회원정보) 호출
	
	@PostMapping("/join03")//회원정보DB입력->join03
	public String join03(MemberDto mDto,
			String phone1, String phone2, String phone3,
			String email1, String email2,
			Model model
			) {
		String phone = phone1+"-"+phone2+"-"+phone3;
		String email = email1+"@"+email2;
		mDto.setPhone(phone);
		mDto.setEmail(email);
		System.out.println(mDto.getId()+","+mDto.getPhone()+","+mDto.getEmail());
		model.addAttribute("name", mDto.getName());
		memberService.insertMember(mDto);
		return "member/join03";
	}//회원정보DB입력->join03
}
