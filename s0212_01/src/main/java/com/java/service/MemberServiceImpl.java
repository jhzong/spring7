package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.MemberDao;
import com.java.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired MemberDao memberDao;
	@Override //로그인확인
	public MemberDto selectLogin(MemberDto mDto) {
		MemberDto m = memberDao.selectLogin(mDto);
		return m;
	}
	
	@Override //회원가입 확인
	public void insertMember(MemberDto mdto) {
		int result = memberDao.insertMember(mdto);
		System.out.println("result : "+result);
	}

}
