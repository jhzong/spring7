package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.MemberDto;
import com.java.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired MemberRepository memberRepository;

	//2.로그인하기
	@Override
	public MemberDto findByIdAndPw(MemberDto mdto) {
		MemberDto memberDto = memberRepository.findByIdAndPw(mdto.getId(),mdto.getPw())
				.orElse(null);
		return memberDto;
	}

	//7.회원데이터 저장(가입)
	@Override
	public void save(MemberDto mdto) {
		memberRepository.save(mdto);
		
	}

	//7-1.아이디 중복확인
	@Override
	public MemberDto findById(String id) {
		MemberDto memberDto = memberRepository.findById(id).orElse(null);
		return memberDto;
	}
}
