package com.java.service;

import com.java.dto.CommentDto;

public interface CommentService {

	//댓글추가
	CommentDto save(CommentDto cdto, int bno);

	//댓글삭제
	void deleteById(int cno);

	//댓글수정
	CommentDto save(CommentDto cdto);

}
