package com.java.service;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.java.dto.BoardDto;

public interface BoardService {

	//3.전체게시글 불러오기-PageableDefault
//	Page<BoardDto> findAll(Pageable pageable);
	//2.전체게시글 불러오기-Pageable
	Map<String, Object> findAll(int page,int size);
	//1.전체게시글 불러오기-sort
//	List<BoardDto> findAll(Sort sort);
	//게시판검색
	Map<String, Object> findContaining(int page, int size, String category, String search);

	//글쓰기저장
	void save(BoardDto bdto);
	//게시글수정
	void update(BoardDto bdto);
	//답글저장
	void reply(BoardDto bdto);

	//게시글상세-1개
	Map<String, Object> findById(Integer bno);
	//게시글삭제
	void deleteById(Integer bno);


}
