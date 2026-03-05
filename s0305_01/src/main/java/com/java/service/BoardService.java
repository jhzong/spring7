package com.java.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Sort;

import com.java.dto.BoardDto;

public interface BoardService {

	//전체게시글 불러오기
//	List<BoardDto> findAll();//sort만 적용
	Map<String, Object> findAll(int page, int size, String category, String search);//하단넘버링+

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
