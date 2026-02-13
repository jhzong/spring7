package com.java.service;

import java.util.List;

import com.java.dto.MemberDto;

public interface MemberService {

	MemberDto selectIdAndPw(MemberDto mDto);

	List<MemberDto> selectAllMem();

}
