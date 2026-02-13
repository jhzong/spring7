package com.java.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.MemberDao;
import com.java.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired MemberDao memberDao;
	
	@Override
	public MemberDto selectIdAndPw(MemberDto mDto) {
		MemberDto m = memberDao.selectIdAndPw(mDto);
		return m;
	}

	@Override
	public void insertMember(MemberDto mDto) {
		memberDao.insertMember(mDto);
	}

	@Override//회원검색
	public MemberDto selectOne(String id) {
		MemberDto memberDto = memberDao.selectOne(id);
		return memberDto;
	}

	@Override//회원정보수정
	public void updateMember(MemberDto mDto) {
		memberDao.updateMember(mDto);
		
	}


}
