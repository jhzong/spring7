package com.java.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.java.dto.BoardDto;
import com.java.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired CustomerRepository customerRepository;
	
	//customer게시판
	@Override
	public Map<String, Object> findAll(int page,int size,String category,String search) {
		//정렬:bgroup-desc,bstep-asc
		Sort sort = Sort.by(Sort.Order.desc("bgroup"), Sort.Order.asc("bstep"));
		//pageable-page,size
		Pageable pageable = PageRequest.of(page-1, size, sort);
		Page<BoardDto> pageList = null; 
		if (category==null||category=="") pageList = customerRepository.findAll(pageable);
		else if (category.equals("all")) pageList = customerRepository.findByBtitleContainingOrBcontentContaining(search,search,pageable);
		else if (category.equals("btitle")) pageList = customerRepository.findByBtitleContaining(search,pageable);
		else if (category.equals("bcontent")) pageList = customerRepository.findByBcontentContaining(search,pageable);
		
		List<BoardDto> list = pageList.getContent();
		int maxPage = pageList.getTotalPages();
		int startPage = ((page-1)/5)*5+1;
		int endPage = Math.min(maxPage, startPage+5-1);
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("maxPage", maxPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("page", page);
		map.put("category", category);
		map.put("search", search);
		
		return map;
	}
	
	//하단넘버링 메소드
	

}
