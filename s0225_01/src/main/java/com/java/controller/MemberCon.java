package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberCon {
	
	@Autowired MemberService memberService;
	@Autowired HttpSession session;

	//회원정보 수정하기(저장)
	@PostMapping("/member/mupdate")
	public String mupdate(MemberDto mdto,
			@RequestParam(name="phone1", required = false) String phone1,
			@RequestParam(name="phone2", required = false) String phone2,
			@RequestParam(name="phone3", required = false) String phone3,
			Model model) {
		String id = (String) session.getAttribute("session_id");
		mdto.setId(id);
		String phone = String.format("%s-%s-%s", phone1, phone2, phone3);
		System.out.println(phone);
		mdto.setPhone(phone);
		//DB저장 - update()
		memberService.update(mdto);
		return "redirect:/member/mlist";
	}
	
	//회원정보 수정페이지
	@GetMapping("/member/mupdate")
	public String mupdate(MemberDto mdto, Model model) {
//		System.out.println("con id : "+mdto.getId());
		MemberDto memberDto = memberService.findById(mdto);
		model.addAttribute("member", memberDto);
		String[] phones = memberDto.getPhone().split("-");
		model.addAttribute("phones", phones);
		return "mupdate";
	}
	
	//회원정보 상세보기
	@GetMapping("/member/mview")
	public String mview(MemberDto mdto, Model model) {
//		System.out.println("con id : "+mdto.getId());
		MemberDto memberDto = memberService.findById(mdto);
		model.addAttribute("member", memberDto);
//		System.out.println(memberDto);
		return "mview";
	}
	
	//회원가입페이지
	@GetMapping("/member/memberShip")
	public String memberShip() {
		return "memberShip";
	}
	
	//회원가입저장
	@PostMapping("/member/memberShip")
	public String memberShip(MemberDto mdto, Model model,
			@RequestParam(name="phone1", required = false) String phone1,
			@RequestParam(name="phone2", required = false) String phone2,
			@RequestParam(name="phone3", required = false) String phone3
			) {
		String phone = String.format("%s-%s-%s", phone1, phone2, phone3);
//		System.out.println(phone);
		mdto.setPhone(phone);
//		System.out.println("con mdto : "+mdto.getId());
		memberService.save(mdto);
		return "redirect:/member/login";
	}
	
	
	//회원삭제
	@ResponseBody
	@DeleteMapping("/member/mdelete")
	public String mdelete(MemberDto mdto, Model model) {
//		System.out.println("mdelete : "+mdto.getId());
		//DB연결
		memberService.deleteById(mdto);
		return "성공";
	}
	
	//젠체회원리스트
	@GetMapping("/member/mlist")
	public String mlist(Model model) {
		//DB연결 - 전체회원리스트 불러오기
		List<MemberDto> list = memberService.findAll();
		model.addAttribute("list", list);
		return "mlist";
	}
	
	//로그아웃
	@GetMapping("/member/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}

	//로그인페이지
	@GetMapping("/member/login")
	public String login() {
		return "login";
	}
	
	//로그인확인
	@PostMapping("/member/login")
	public String login(MemberDto mdto) {
		System.out.println("Con mdto : "+mdto.getId()+","+mdto.getPw());
		
		MemberDto memberDto = memberService.findByIdAndPw(mdto);
		if(memberDto!=null) {
			System.out.println("로그인 되었습니다.");
			System.out.println("login memberDto : "+memberDto.getName());
			//세션추가
			session.setAttribute("session_id", memberDto.getId());
			session.setAttribute("session_name", memberDto.getName());
			return "redirect:/";
		}else {
			System.out.println("아이디 또는 패스워즈 불일치");
			return "login";
		}
	}
}
