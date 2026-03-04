package com.java.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.CommentDto;
import com.java.service.CommentService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CommentCon {

	@Autowired HttpSession session;
	@Autowired CommentService commentService;
	
	@ResponseBody
	@PostMapping("/comment/save")
	public CommentDto save(CommentDto cdto,
			@RequestParam(name = "bno",defaultValue = "1") int bno
			) {
		//service 전달
		System.out.println("Con ccontent : "+cdto.getCcontent());
		System.out.println("Con bno : "+bno);
//		Map<String, Object> map = new HashMap<>();
//		map.put("comment", commentService.save(cdto, bno));
		CommentDto commentDto = commentService.save(cdto, bno);
		
		return commentDto;
	}
	
	@ResponseBody
	@PostMapping("/comment/save2")
	public CommentDto save2(CommentDto cdto,
			@RequestParam(name = "bno",defaultValue = "1") int bno,
			@RequestParam(name = "id",defaultValue = "1") String id,
			@RequestParam(name = "name",defaultValue = "1") String name
			) {
		//service 전달
		System.out.println("Con ccontent : "+cdto.getCcontent());
		System.out.println("Con bno : "+bno);
		System.out.println("Con id : "+id);
		System.out.println("Con name : "+name);
//		Map<String, Object> map = new HashMap<>();
//		map.put("comment", commentService.save(cdto, bno));
//		CommentDto commentDto = commentService.save(cdto, bno);
		
		CommentDto commentDto = new CommentDto();
		return commentDto;
	}
}
