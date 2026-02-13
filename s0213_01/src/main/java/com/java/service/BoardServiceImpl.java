package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.BoardDao;
import com.java.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired BoardDao boardDao;

	@Override//게시글전체
	public List<BoardDto> selectAll() {
		List<BoardDto> list = boardDao.selectAll();
		return list;
	}
}
