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
@Entity
public class CommentDto {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cno;
	@Column(length = 2000,nullable = false)
	private String ccontent;
	//CommentDto-to-BoardDto
	@ManyToOne
	@JoinColumn(name = "bno")
	private BoardDto boardDto;
	//CommentDto-to-MemberDto
	@ManyToOne
	private MemberDto memberDto;
	@UpdateTimestamp
	private Timestamp cdate;
}
