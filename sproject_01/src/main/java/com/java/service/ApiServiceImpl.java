package com.java.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.java.dto.SaleDto;
import com.java.repository.GraphRepository;

@Service
public class ApiServiceImpl implements ApiService {

	@Autowired JavaMailSender mailSender;
	@Autowired GraphRepository graphRepository;
	
	//1.인증메일 발송
	@Async //비동기처리 - 이메일 발송 딜레이 해결
	@Override
	public String emailSend(String email) {
		
		//10자리 랜덤문자열
		String pwCode = getCreateKey();
	
		//메일발송
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);//받는주소
		message.setFrom("jhzong@naver.com");//보낸주소
		message.setSubject("[자뎅몰-test]이메일 인증번호");//제목
		message.setText("인증코드 : "+pwCode);//내용
		mailSender.send(message);
		
		System.out.println("이메일 발송완료");
		return pwCode;
		
		//DB에 저장 - 이메일,인증번호,날짜
		
	}

	//비밀번호 자동생성
	public String getCreateKey() {
		//uuid - 36자리 랜덤문자열 자동생성
		String uuid = UUID.randomUUID().toString().substring(0, 8);//0~8자리까지만 잘라내기
		System.out.println("uuid : "+uuid);
		
		//10자리 랜덤문자열 수동생성
		char[] charSet = new char[] {
				'0','1','2','3','4','5','6','7','8','9',
				'A','B','C','D','E','F','G','H','I','J',
				'K','L','M','N','O','P','Q','R','S','T',
				'U','V','X','Y','Z'
		};
		String pwCode = "";
		int idx = 0;
		for(int i=0;i<10;i++) {
			idx = (int)(Math.random()*35);
			pwCode += charSet[idx];
		}
		System.out.println("pwCode : "+pwCode);
		return pwCode;
	}

	//3-2.그래프 데이터 불러오기
	@Override
	public List<SaleDto> findByIdContaining(String syearMonth) {
		List<SaleDto> list = graphRepository.findBySyearMonthContaining(syearMonth);
		return list;
	}
}
