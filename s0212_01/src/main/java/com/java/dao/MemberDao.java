package com.java.dao;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.MemberDto;
@Mapper
public interface MemberDao {

	//로그인확인
	MemberDto selectLogin(MemberDto mDto);

	//회원가입 확인
	int insertMember(MemberDto mdto);

}
