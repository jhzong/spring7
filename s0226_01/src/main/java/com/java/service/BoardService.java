package com.java.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.java.dto.BoardDto;

public interface BoardService {

	//전체게시글 불러오기
	List<BoardDto> findAll(Sort sort);

	//글쓰기 저장
	void save(BoardDto bdto);

}
