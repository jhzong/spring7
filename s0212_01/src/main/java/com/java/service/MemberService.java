package com.java.service;

import com.java.dto.MemberDto;

public interface MemberService {

	//로그인확인
	MemberDto selectLogin(MemberDto mDto);

	//회원가입 확인
	void insertMember(MemberDto mdto);

}
