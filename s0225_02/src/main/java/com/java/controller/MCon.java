package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MCon {

	@Autowired MemberService memberService;
	@Autowired HttpSession session;
	
	// 로그인페이지 출력
	@GetMapping("/member/login")
	public String login() {
		return "login";
	}
	
	// 로그인 확인
	@PostMapping("/member/login")
	public String login(MemberDto mdto) {
//		System.out.println("Conn mdto : "+mdto.getId()+","+mdto.getPw());
		
		MemberDto memberDto = memberService.findByIdAndPw(mdto);
		if (memberDto!=null) {
			System.out.println("로그인 되었습니다.");
//			System.out.println("login memberDto : "+memberDto.getId()+","+memberDto.getName());
			//session저장
			session.setAttribute("session_id", memberDto.getId());
			session.setAttribute("session_name", memberDto.getName());
			return "redirect:/";
		}else {
			System.out.println("아이디 또는 패스워드 불일치");
			return "login";
		}
	}
	
	// 로그아웃
	@GetMapping("/member/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}
	
	// 회원목록출력
	@GetMapping("/member/mlist")
	public String mlist(Model model) {
		//DB연결 회원정보 전체불러오기
		List<MemberDto> list = memberService.findAll();
		model.addAttribute("list", list);
//		System.out.println("list 개수 : "+list.size());
		return "mlist";
	}
	
	// 회원정보삭제
	@ResponseBody
	@DeleteMapping("/member/mdelete")
	public String mdelete(MemberDto mdto, Model model) {
//		System.out.println("삭제할 아이디 : "+mdto.getId());
		// DB연결
		memberService.deleteById(mdto);
		return "성공";
	}
	
	// 회원가입페이지
	@GetMapping("/member/join")
	public String join() {
		return "join";
	}
	
	// 회원가입-정보저장
	@PostMapping("/member/join")
	public String doJoin(MemberDto mdto, Model model) {
		
		return "redirect:/";
	}
}
