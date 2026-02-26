package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dto.BoardDto;
import com.java.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired BoardRepository boardRepository;
	
	//전체게시글 불러오기
	@Override
	public List<BoardDto> findAll(Sort sort) {
		List<BoardDto> list = boardRepository.findAll(sort);
		return list;
	}

	//글쓰기 저장
	@Transactional//method 완료시 기존의 연속성 context가 수정되면 DB에 자동반영.
	@Override
	public void save(BoardDto bdto) {
		//repo에 저장시 객체를 리턴해줌
		BoardDto boardDto = boardRepository.save(bdto);
		//bgroup에 bno번호를 다시 넣어줌
		boardDto.setBgroup(boardDto.getBno());
//		boardRepository.save(boardDto);//@Transactional이 있으면 생략 가능
	}

}
