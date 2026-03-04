package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.BoardDto;
import com.java.dto.CommentDto;
import com.java.dto.MemberDto;
import com.java.repository.BoardRepository;
import com.java.repository.CommentRepository;
import com.java.repository.MemberRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired CommentRepository commentRepository;
	@Autowired MemberRepository memberRepository;
	@Autowired BoardRepository boardRepository;
	@Autowired HttpSession session;
	
	@Override
	public CommentDto save(CommentDto cdto, int bno) {
		String id = (String)session.getAttribute("session_id");
		MemberDto mdto = memberRepository.findById(id).get();
		cdto.setMemberDto(mdto);
		BoardDto bdto = boardRepository.findById(bno).get();
		cdto.setBoardDto(bdto);
		System.out.println("ComImpl :"+bno);
		CommentDto commentDto = commentRepository.save(cdto);
		return commentDto;
	}

}
