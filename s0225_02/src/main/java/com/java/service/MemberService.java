package com.java.service;

import java.util.List;

import com.java.dto.MemberDto;

public interface MemberService {

	// 로그인 확인
	MemberDto findByIdAndPw(MemberDto mdto);

	// 회원목록출력
	List<MemberDto> findAll();

	// 회원정보삭제
	void deleteById(MemberDto mdto);

}
