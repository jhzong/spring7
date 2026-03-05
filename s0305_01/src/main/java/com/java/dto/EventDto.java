package com.java.dto;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class EventDto {

	private Integer eno;//이벤트번호
    private String etitle;//제목
    private String econtent;//내용
    private String ewriter;//작성자
    
    private String thumbnailImg;//이벤트썸네일
    private String detailImg;//이미지-상세페이지
    
    private Timestamp startDate;//시작일
    private Timestamp endDate;//종료일
    
    private Timestamp crdate;//생성일
    private Timestamp update;//수정일

    private int viewCount;//조회수
    private boolean active;//진행중or종료
}
