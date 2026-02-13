package com.java.service;

import java.util.List;

import com.java.dto.BoardDto;

public interface BoardService {

	//게시글전체
	List<BoardDto> selectAll();

}
