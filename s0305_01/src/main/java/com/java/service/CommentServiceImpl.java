package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	//댓글추가
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

	//댓글삭제
	@Override
	public void deleteById(int cno) {
		commentRepository.deleteById(cno);
		
	}

	//댓글수정
	@Transactional//context에 임시저장 "}"를 만나면 전까지 자동저장
	@Override
	public CommentDto save(CommentDto cdto) {
		// cdto -> cno(O),ccontent(O),memberdto(X),boarddto(X),cdate(X)
		// save() -> cno가 있으면 update/ cno가 없으면 insert
		//01.select
		CommentDto commentDto = commentRepository.findById(cdto.getCno()).get();
		commentDto.setCcontent(cdto.getCcontent());
		//CommentDto commentDto = commentRepository.save(cdto);
		return commentDto;
	}

}
