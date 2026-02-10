package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.dto.BoardDto;

@Controller
public class BController {

	@GetMapping("/board")
	public String board() {
		return "board";
	}
	
	@PostMapping("/board")
	public String doBoard(BoardDto bdto, Model model) {
		model.addAttribute("board", bdto);
		return "doBoard";
	}
}
