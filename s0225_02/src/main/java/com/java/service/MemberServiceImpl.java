package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.MemberDto;
import com.java.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired MemberRepository memberRepository;
	
	// 로그인 확인
	@Override
	public MemberDto findByIdAndPw(MemberDto mdto) {
		MemberDto memberDto = memberRepository
				.findByIdAndPw(mdto.getId(),mdto.getPw())
				.orElse(null);
				
		return memberDto;
	}
	
	// 회원목록출력
	@Override
	public List<MemberDto> findAll() {
		List<MemberDto> list =  memberRepository.findAll();
		return list;
	}
	
	// 회원정보삭제
	@Override
	public void deleteById(MemberDto mdto) {
		memberRepository.deleteById(mdto.getId());
		
	}

}
