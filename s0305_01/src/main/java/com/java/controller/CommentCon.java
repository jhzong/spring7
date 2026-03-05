package com.java.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.CommentDto;
import com.java.service.CommentService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CommentCon {

	@Autowired HttpSession session;
	@Autowired CommentService commentService;
	
	//01.댓글저장
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
	}//save
	
	//02.댓글삭제
	@ResponseBody
	@DeleteMapping("/comment/delete")
	private String delete(CommentDto cdto) {
		int cno = cdto.getCno();
		System.out.println("댓글번호 : "+cno);
		//service 전달
		commentService.deleteById(cno);
		return "삭제성공";
	}
	
	//03-3.댓글수정
	@ResponseBody
	@PutMapping("/comment/update")
	private CommentDto update(CommentDto cdto) {
		System.out.println("댓글번호 : "+cdto.getCno());
		System.out.println("댓글내용 : "+cdto.getCcontent());
		//service 전달
		CommentDto commentDto = commentService.save(cdto);
		System.out.println("cdate : "+commentDto.getCdate());
		return commentDto;
	}
}
