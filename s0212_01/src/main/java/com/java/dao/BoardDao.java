package com.java.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;
@Mapper
public interface BoardDao {

	//게시글 전체 가져오기
	List<BoardDto> selectAll();

}
