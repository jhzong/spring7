package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.MemberDao;
import com.java.dto.MemberDto;


@Service
public class memberServiceImpl implements MemberService {

	@Autowired MemberDao memberDao;

	@Override
	public MemberDto selectIdAndPw(MemberDto mDto) {

		MemberDto m = memberDao.selectIdAndPw(mDto);
		return m;
	}

	@Override
	public List<MemberDto> selectAllMem() {
		
		List<MemberDto> list = memberDao.selectAllMem();
		return list;
	}

}
