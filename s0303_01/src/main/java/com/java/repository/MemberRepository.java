package com.java.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.java.dto.MemberDto;
//JpaRepository를 반드시 상속 할 것
//<dto객체,dto객체 PK타입>
//findAll(),findById(),save(),delete(),deleteById(),count()<=기본 제공

public interface MemberRepository extends JpaRepository<MemberDto, String> {

	//(1)로그인확인(JPA) - 1개 데이터전달 : Optional타입이어야 함.
	Optional<MemberDto> findByIdAndPw(String id, String pw);

	//(2)로그인확인(임의method)
//	@Query(value = "select * from memberdto where id=? and pw=?",
//			nativeQuery = true)
//	Optional<MemberDto> selectLogin(String id,String pw);
	
	//(3)로그인확인(임의method)
	// MemberDto 이른을 클래스명과 일치시켜야 함(대소문자)
//	@Query("select m from MemberDto m where m.id=:id and m.pw=:pw")
//	Optional<MemberDto> selectLogin(@Param("id") String id,
//			@Param("pw") String pw);

}
