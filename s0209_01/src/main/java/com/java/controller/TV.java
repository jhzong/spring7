package com.java.controller;

import org.springframework.stereotype.Service;

@Service// service만 바꿔주면 버젼 변경(서비스하는 앱에만 넣기)
public class TV implements Product {

	@Override
	public String getName() {
		String name = "삼성TV 01";
		return name;
	}
	
}
