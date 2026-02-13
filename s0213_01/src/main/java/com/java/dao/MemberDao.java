package com.java.dao;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.MemberDto;

@Mapper
public interface MemberDao {

	MemberDto selectIdAndPw(MemberDto mDto);

	void insertMember(MemberDto mDto);

	//회원검색
	MemberDto selectOne(String id);

	//회원정보수정
	void updateMember(MemberDto mDto);

}
