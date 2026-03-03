package com.java.dto;

import java.sql.Timestamp;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity//jpa
public class CommentDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//시퀀스
	private Integer cno;
	@Column(length = 2000,nullable = false)
	private String ccontent;
	@ManyToOne//연관관계
	@JoinColumn(name = "bno")
	private BoardDto boardDto;
	@ManyToOne
	@JoinColumn(name = "id")
	private MemberDto memberDto;
	@UpdateTimestamp//데이터가 입력되때마다 수정됨
//	@CreationTimestamp//1번 입력되면 변경불가
	private Timestamp cdate;
}
