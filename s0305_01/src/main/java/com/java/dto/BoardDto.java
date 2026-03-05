package com.java.dto;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SequenceGenerator(//boardDto에 이미 100개 개시글 있음
		name = "boardDto_seq_generator",//generator이름
		sequenceName = "boardDto_seq",	//oracle테이블 시퀀스이름
		initialValue = 101,				//시작번호
		allocationSize = 1				//메모리 할당범위
		)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE,
//	generator = "boardDto_seq")//oracle 시퀀스

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class BoardDto {

//	@GeneratedValue(strategy = GenerationType.IDENTITY)//DB시퀀스
	@GeneratedValue(generator="boardDto_seq_generator")
	@Id
	private Integer bno;
	@Column(length = 1000,nullable = false)
	private String btitle;
	@Lob//대용량데이터-CLOB
	private String bcontent;
	
//	private String id;//member의 PK -> FK로 사용
//	@ManyToMany//여러회원이 여러개의 글을 작성-하단댓글
//	@OneToMany//1개의 게시글을 여러명이 소유함
	// 연관관계 형성-FK를 구성함.
	@ManyToOne(fetch = FetchType.EAGER)//1명의 회원은 여러개 개시글 작성가능
	@JoinColumn(name = "id")//DB에 저장되는 컬럼은 id
	private MemberDto memberDto;
	private int bgroup;
	@ColumnDefault("0")
	private int bstep;
	@ColumnDefault("0")
	private int bindent;
	@ColumnDefault("0")
	private int bhit;
	@Column(length = 100)
	private String bfile;
	@CreationTimestamp
	private Timestamp bdate;

	//BoardDto-to-CommentDto - FK키 생성해제, 바로가져오기, 게시글삭제 시 댓글모두삭제
	@OneToMany(mappedBy = "boardDto",fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"boardDto"})//무한루프 방지
	@OrderBy("cno desc")
	private List<CommentDto> commentList;
}
