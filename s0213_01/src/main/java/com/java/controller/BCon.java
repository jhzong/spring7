package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.BoardDto;
import com.java.service.BoardService;

@Controller
@RequestMapping("/board")
public class BCon {

	@Autowired BoardService boardService;
	
	@GetMapping("/blist")//게시글전체
	public String blist(Model model) {
		List<BoardDto> list = boardService.selectAll();
		model.addAttribute("list", list);
		System.out.println("list개수 : "+list.size());
		return "board/blist";
	}//게시글전체
	
	@GetMapping("/bwrite")//게시글작성
	public String bwrite() {
		return "board/bwrite";
	}//게시글작성
	
	@PostMapping("/bwrite")//게시글저장
	public String bwrite(BoardDto bDto, Model model) {
		System.out.println("bwrite에서 넘어온 데이터 : "+bDto.getBtitle());
		return "redirect:/board/blist?flag=1";
	}//게시글저장
}
