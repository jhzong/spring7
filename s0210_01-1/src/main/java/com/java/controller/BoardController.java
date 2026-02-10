package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.java.dto.BoardDto;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BoardController {

	// 데이터 전달 방법(3) @pathVariable
	@GetMapping("/boardView/{bno}")
	public ModelAndView boardView(@PathVariable Integer bno) {
		
		BoardDto b = BoardDto.builder().bno(1).btitle("제목입니다.")
				.bcontent("내용입니다.").build();
		
//		System.out.println("bno : "+bno);
		ModelAndView mv = new ModelAndView();
		mv.addObject("bno", bno);
		mv.setViewName("boardView");
		return mv;
	}
	
	// 데이터 전달 방법(2) 파라미터값 → @RequestParam
//	@GetMapping("/boardView")
//	public ModelAndView boardView(Integer bno, Model model) {
//		System.out.println("bno : "+bno);
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("bno", bno);
//		mv.setViewName("boardView");
//		return mv;
//	}
	
	@GetMapping("/board")
	public String board() {
		return "board";
	}
	
	// ★★데이터 전달 방법(form)(1)-4.객체타입
	@PostMapping("/board")
	public String board(BoardDto bdto, Model model) {
		System.out.println(String.format("%d,%s,%s,%s", 
				bdto.getBno(), bdto.getBtitle(), bdto.getBcontent(), bdto.getId()));
		
		model.addAttribute("board", bdto);
		return "doBoard";
	}
	
	// 데이터 전달 방법(form)(1)-3.축약방식
//	@PostMapping("/board")
//	public String board(
//			//ex)@RequestParam(name="bno",defaultValue="1")
//			int bno,String btitle,String bcontent,String id,
//			Model model) {
//		
//		System.out.println(String.format("%d,%s,%s,%s", bno, btitle, bcontent, id));
//		
//		model.addAttribute("bno", bno);
//		model.addAttribute("btitle", btitle);
//		model.addAttribute("bcontent", bcontent);
//		model.addAttribute("id", id);
//		return "doBoard";
//	}
	
	// 데이터 전달 방법(form)(1)-2.@RequestParam 방식→ 데이터 타입 자동형변환
	// 이름이 같으면 이름생략, @RequestParam 생략가능
	// 타입이 다른경우 null값일때 에러 - default값 설정(예시)
//	@PostMapping("/board")
//	public String board(
//			@RequestParam("bno")
//			int bno,String btitle,String bcontent,String id,
//			Model model) {
//		
//		System.out.println(String.format("%d,%s,%s,%s", bno, btitle, bcontent, id));
//		
//		model.addAttribute("bno", bno);
//		model.addAttribute("btitle", btitle);
//		model.addAttribute("bcontent", bcontent);
//		model.addAttribute("id", id);
//		return "doBoard";
//	}

	// 데이터 전달 방법(form)(1)-1.HttpServletRequest 방식(데이터를 str로 받음)
//	@PostMapping("/board")
//	public String board(HttpServletRequest request, Model model) {
//		int bno = Integer.parseInt(request.getParameter("bno"));
//		String btitle = request.getParameter("btitle");
//		String bcontent = request.getParameter("bcontent");
//		String id = request.getParameter("id");
//		
//		model.addAttribute("bno", bno);
//		model.addAttribute("btitle", btitle);
//		model.addAttribute("bcontent", bcontent);
//		model.addAttribute("id", id);
//		
//		System.out.println(model);
//		return "doBoard";
//	}
}
