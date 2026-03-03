package com.java.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dto.BoardDto;
import com.java.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired BoardRepository boardRepository;
	
	//3.전체게시글 불러오기-PageableDefault
//	@Override
//	public Page<BoardDto> findAll(Pageable pageable) {
//		//정렬방법 - bgroup으로 역순,bstep으로 순차<-답글달때 필요
//		Sort sort = Sort.by(
//				Sort.Order.desc("bgroup"),Sort.Order.asc("bstep")
//				);
//		// Pageable - 현재페이지,사이즈크기,정렬
//		Page<BoardDto> pageList = boardRepository.findAll(pageable);
//
//		System.out.println("pageList 글내용 : "+pageList.getContent());
//		System.out.println("pageList 총개수 : "+pageList.getTotalElements());
//		System.out.println("pageList 총페이지수 : "+pageList.getTotalPages());
//
//		return pageList;
//	}
	
	//2.전체게시글 불러오기-Pageable
	@Override
	public Map<String, Object> findAll(int page,int size) {
		//정렬방법 - bgroup으로 역순,bstep으로 순차<-답글달때 필요
		Sort sort = Sort.by(
				Sort.Order.desc("bgroup"),Sort.Order.asc("bstep")
				);
		// Pageable - 현재페이지,사이즈크기,정렬,Pageable=0부터 시작
		Pageable pageable = PageRequest.of(page-1, size, sort);
		//Page타입으로 리턴 받음(page처리 할 때)
		Page<BoardDto> pageList = boardRepository.findAll(pageable);
		//List타입으로 리턴 받음(page처리 필요없을 때)-일반
//		List<BoardDto> list = boardRepository.findAll();
		
		//하단넘버링에 필요한 데이터
		int maxPage = pageList.getTotalPages();         //마지막페이지
		int startPage = ((page)/10)*10+1;               //하단넘버링 시작번호
		int endPage = Math.min(startPage+10-1, maxPage);//하단넘버링 마지막번호
		List<BoardDto> list = pageList.getContent();    //게시글내용
		Map<String, Object> map = new HashMap<>();
		map.put("page", page);//Pageable=0부터 시작
		map.put("maxPage", maxPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("list", list);
		//하단넘버링에 필요한 데이터
		
		return map;
	}
	
	//전체게시글 불러오기-sort
//	@Override
//	public List<BoardDto> findAll(Sort sort) {
//		List<BoardDto> list = boardRepository.findAll(sort);
//		return list;
//	}

	//글쓰기저장
	@Transactional//method 완료시 기존의 연속성 context가 수정되면 DB에 자동반영.
	@Override
	public void save(BoardDto bdto) {
		//repo에 저장시 객체를 리턴해줌
		BoardDto boardDto = boardRepository.save(bdto);
		//bgroup에 bno번호를 다시 넣어줌
		boardDto.setBgroup(boardDto.getBno());
//		boardRepository.save(boardDto);//@Transactional이 있으면 생략 가능
	}
	
	//게시글수정
	@Transactional
	@Override
	public void update(BoardDto bdto) {
		BoardDto boardDto = boardRepository.findById(bdto.getBno()).get();
		boardDto.setBtitle(bdto.getBtitle());
		boardDto.setBcontent(bdto.getBcontent());
		boardDto.setBfile(bdto.getBfile());
		boardDto.setBdate(new Timestamp(System.currentTimeMillis()));
//		boardRepository.save(boardDto);
	}

	//답글저장
	@Transactional
	@Override
	public void reply(BoardDto bdto) {
		//1.부모bgroup에서 부모보다 큰 bstep에 1을 증가
		boardRepository.replyBstepUp(bdto.getBgroup(),bdto.getBstep());
		
		//2.bgroup:부모값,bstep&&bindent:부모값+1
		bdto.setBgroup(bdto.getBgroup());	
		bdto.setBstep(bdto.getBstep()+1);	
		bdto.setBindent(bdto.getBindent()+1);	
		boardRepository.save(bdto);
	}
	
	//게시글상세-1개
	//findAll(),findById(),save(),delete(),deleteById(),count()
	@Transactional(readOnly = true)//readOnly=true:정합성을 유지
	@Override
	public Map<String, Object> findById(Integer bno) {
		Map<String, Object> map = new HashMap<>();
		//이전글
		BoardDto preDto = boardRepository.findByPre(bno).orElse(null);
		//다음글
		BoardDto nextDto = boardRepository.findByNext(bno).orElse(null);
		//현재글
		BoardDto boardDto = boardRepository.findById(bno).orElse(null);
		//객체를 map에 담는다.
		map.put("preDto", preDto);
		map.put("nextDto", nextDto);
		map.put("boardDto", boardDto);
		
		//조회수1증가 - 새로고침 조회수 증가 방지법 cookie,session,db등
		boardDto.setBhit(boardDto.getBhit()+1);
		
		return map;
	}

	//게시글삭제
	@Override
	public void deleteById(Integer bno) {
		boardRepository.deleteById(bno);
	}

}
