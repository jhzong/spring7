package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.BoardDto;
import com.java.service.BoardService;

@Controller
@RequestMapping("/board")
public class BCon {

	@Autowired BoardService boardService;
	
	@GetMapping("/blist")
	public String blist(Model model) {
		
		// 게시글 전체-List
		List<BoardDto> list = boardService.selectAll();
		model.addAttribute("list", list);
		System.out.println("list 개수 : "+list.size());
		return "blist";
	}
}
