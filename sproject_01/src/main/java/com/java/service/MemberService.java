package com.java.service;

import com.java.dto.MemberDto;

public interface MemberService {

	//2.로그인하기
	MemberDto findByIdAndPw(MemberDto mdto);

	//7.회원데이터 저장(가입)
	void save(MemberDto mdto);

	//7-1.아이디 중복확인
	MemberDto findById(String id);

}
