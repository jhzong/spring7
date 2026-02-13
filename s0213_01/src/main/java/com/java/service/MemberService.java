package com.java.service;

import com.java.dto.MemberDto;

public interface MemberService {

	MemberDto selectIdAndPw(MemberDto mDto);

	void insertMember(MemberDto mDto);

	//회원검색
	MemberDto selectOne(String id);

	//회원정보수정
	void updateMember(MemberDto mDto);



}
