package com.java.service;

import java.util.List;

import com.java.dto.SaleDto;

public interface ApiService {

	//1.인증메일 발송
	String emailSend(String email);

	//3-2.그래프 데이터 불러오기
	List<SaleDto> findByIdContaining(String syearMonth);

}
