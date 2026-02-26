package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dto.MemberDto;
import com.java.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired MemberRepository memberRepository;
	
	@Override
	public MemberDto findByIdAndPw(MemberDto mdto) {
		System.out.println("service mdto:"+mdto.getId());
		//findByIdAndPw
		//select * memberDto where id=? and pw=?
		//findByNameOrPhone
		//select * memberDto where name=? or phone=?
		//select 1개일때 -> null에 대한 처리를 해야함.
		// 1 .get():에러처리X
		// 2 .orElse():null처리/빈객체처리
		// 3 .orElseThrow():예외처리를 해서 넘겨줌
		MemberDto memberDto = memberRepository.
				findByIdAndPw(mdto.getId(),mdto.getPw())
//				.get()
				.orElse(null)
//				.orElse(new MemberDto())
//				.orElseThrow(
//						()->{return new IllegalArgumentException();}
//						)
				;
		return memberDto;
		//지정된 이름을 따르지 않을 경우
//		MemberDto memberDto = memberRepository.
//				selectLogin(mdto.getId(),mdto.getPw()).orElse(null);
//		return memberDto;
	}

	//전체회원리스트
	//select : 여러개의 데이터를 가져오는 경우, null처리 필요X
	//List타입 : null값 가능
	@Override
	public List<MemberDto> findAll() {
		//기본 구문인 findAll()은 MemberRepository에 메소드선언 필요X
		List<MemberDto> list = memberRepository.findAll();
		return list;
	}

	//회원삭제
	@Override
	public void deleteById(MemberDto mdto) {
		memberRepository.deleteById(mdto.getId());
		
	}

	//회원가입
	@Transactional
	@Override
	public void save(MemberDto mdto) {
		memberRepository.save(mdto);
		
	}

	//회원상세
	@Override
	public MemberDto findById(String id) {
		MemberDto memberDto = memberRepository.findById(id)
				.orElse(null);
		return memberDto;
	}

	//회원정보 수정저장
	@Transactional
	@Override
	public void update(MemberDto mdto) {
		MemberDto memberDto = memberRepository.findById(mdto.getId())
				.orElse(null);
		
		// 수정1. 검색후 검색된 데이터의 값변경
		// 아이디,비번,이름,폰,이메일,성별,취미
		// 폰,이메일,성별,취미만 수정
//		memberDto.setPhone(mdto.getPhone());
//		memberDto.setEmail(mdto.getEmail());
//		memberDto.setGender(mdto.getGender());
//		memberDto.setHobby(mdto.getHobby());
		
		// 수벙법2. save() : 아이디가 없으면 insert, 아이디가 있으면 update()
		memberRepository.save(mdto);
	}

}
