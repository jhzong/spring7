package com.java.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.data.web.SortDefault.SortDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.java.dto.BoardDto;
import com.java.dto.MemberDto;
import com.java.service.BoardService;
import com.java.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BCon {

	@Autowired BoardService boardService;
	@Autowired HttpSession session;
	@Autowired MemberService memberService;

	//답글저장
	@PostMapping("/board/breply")
	public String breply(BoardDto bdto,Model model,
			@RequestPart("file") MultipartFile files
			) {
		System.out.println("Conn bno : "+bdto.getBno());
		System.out.println("Conn bfile : "+bdto.getBfile());
		
		
		// 파일 업로드
		if(!files.isEmpty()) {//업로드할 파일이 있다면...
			String fName = files.getOriginalFilename();
			long time = System.currentTimeMillis();
			String refName = String.format("%s_%s", time, fName);//파일이름에 임의숫자 추가(중복방지)
			System.out.println("파일이름 : "+fName);
			System.out.println("파일변경이름 : "+refName);
			String fileUploadUrl = "c:/upload/";
			File f = new File(fileUploadUrl+refName);
			try {
				files.transferTo(f);
				bdto.setBfile(refName);// 변경된 파일이름 저장
			} catch (IOException e) {e.printStackTrace();}
		}
		
		String id = (String) session.getAttribute("session_id");
		//memberDto를 검색해 저장
		MemberDto mdto = memberService.findById(id);
		bdto.setMemberDto(mdto);
		//답글저장
		boardService.reply(bdto);
		
		return "redirect:/board/blist";
	}
	
	//답글쓰기페이지
	@GetMapping("/board/breply")
	public String breply(//@RequestParam<=>/**/*?bno=${board.bno}
			@RequestParam(name = "bno",required = false) Integer bno,
			Model model) {
//		System.out.println("Conn bno : "+bno);
		//DB에서 불러오기
		Map<String, Object> map = boardService.findById(bno);
		model.addAttribute("board", map.get("boardDto"));
		return "breply";
	}
	
	//게시글수정 저장
	@PostMapping("/board/bupdate")
	public String bupdate(BoardDto bdto,
			@RequestPart("file") MultipartFile files,
			Model model) {
//		System.out.println("Conn bno : "+bdto.getBno());
//		System.out.println("Conn bfile : "+bdto.getBfile());
		// 파일 업로드
		if(!files.isEmpty()) {//업로드할 파일이 있다면...
			String fName = files.getOriginalFilename();
			long time = System.currentTimeMillis();
			String refName = String.format("%s_%s", time, fName);//파일이름에 임의숫자 추가(중복방지)
//			System.out.println("파일이름 : "+fName);
//			System.out.println("파일변경이름 : "+refName);
			String fileUploadUrl = "c:/upload/";
			File f = new File(fileUploadUrl+refName);
			try {
				files.transferTo(f);
				bdto.setBfile(refName);// 변경된 파일이름 저장
			} catch (IOException e) {e.printStackTrace();}
		}
		
		//String id = (String) session.getAttribute("session_id");
		//memberDto를 검색해 저장
		//MemberDto mdto = memberService.findById(id);
		//bdto.setMemberDto(mdto);
		//글쓰기저장
		boardService.update(bdto);
		
		return "redirect:/board/blist";
	}
	
	//게시글수정
	@GetMapping("/board/bupdate")
	public String bupdate(//@RequestParam<=>/**/*?bno=${board.bno}
			@RequestParam(name = "bno",required = false) Integer bno,
			Model model) {
//		System.out.println("Conn bno : "+bno);
		//DB에서 불러오기
		Map<String, Object> map = boardService.findById(bno);
		model.addAttribute("board", map.get("boardDto"));
		return "bupdate";
	}
	
	//게시글삭제
	@ResponseBody//데이터로 전달
	@DeleteMapping("/board/bdelete")
	public String bdelete(
			@RequestParam(name = "bno",required = false) Integer bno,
			Model model) {
//		System.out.println("Conn bno : "+bno);
		boardService.deleteById(bno);
		return "성공";
	}
	
	//게시판 상세페이지
	@GetMapping("/board/bview/{bno}")
	public String bview(//@PathVariable<=>/**/*/bno&&Mapping(/**/*/{bno})
			@PathVariable(name = "bno",required = false) Integer bno,
			@PathVariable(name = "page",required = false) Integer page,
			@RequestParam(name = "category",required = false) String category,
			@RequestParam(name = "search",required = false) String search,
			Model model) {
		Map<String, Object> map = boardService.findById(bno);
		//게시글1개
		model.addAttribute("board", map.get("boardDto"));
		//하단댓글
		model.addAttribute("commentList", map.get("commentList"));
		model.addAttribute("preBoard", map.get("preDto"));
		model.addAttribute("nextBoard", map.get("nextDto"));
		model.addAttribute("page", page);
		model.addAttribute("category", category);
		model.addAttribute("search", search);
		return "bview";
	}
	
	//글쓰기 페이지
	@GetMapping("/board/bwrite")
	public String bwrite(Model model) {
		
		return "bwrite";
	}
	
	//글쓰기 저장
	@PostMapping("/board/bwrite")
	public String bwrite(BoardDto bdto, Model model,
			@RequestPart("file") MultipartFile files
			) {
		System.out.println("Conn bdto : "+bdto.getBtitle());
		// 파일 업로드
		if(!files.isEmpty()) {//업로드할 파일이 있다면...
			String fName = files.getOriginalFilename();
			long time = System.currentTimeMillis();
			String refName = String.format("%s_%s", time, fName);//파일이름에 임의숫자 추가(중복방지)
			System.out.println("파일이름 : "+fName);
			System.out.println("파일변경이름 : "+refName);
			String fileUploadUrl = "c:/upload/";
			File f = new File(fileUploadUrl+refName);
			try {
				files.transferTo(f);
				bdto.setBfile(refName);// 변경된 파일이름 저장
			} catch (IOException e) {e.printStackTrace();}
		}
		
		String id = (String) session.getAttribute("session_id");
		//memberDto를 검색해 저장
		MemberDto mdto = memberService.findById(id);
		bdto.setMemberDto(mdto);
		//글쓰기저장
		boardService.save(bdto);
		return "redirect:/board/blist";
	}
	
	//3.전체게시글 불러오기-PageableDefault
//	@ResponseBody// 데이터로 전달
//	@GetMapping("/board/blist")
//	public Page<BoardDto> blist(
//			@PageableDefault(page=0,size=10)
//			@SortDefaults({
//				@SortDefault(sort="bgroup",direction = Sort.Direction.DESC),
//				@SortDefault(sort="bstep",direction = Sort.Direction.ASC)
//			}) Pageable pageable,
//			Model model) {
//		Page<BoardDto> pageList = boardService.findAll(pageable);
//		return pageList;
//	}//blist-PageableDefault
	
	//2.전체게시글 불러오기-Pageable(page,size)
//	@ResponseBody// 데이터로 전달
	@GetMapping("/board/blist")
	public String blist(
			@RequestParam(name="page",defaultValue = "1") int page,
			@RequestParam(name="size",defaultValue = "10") int size,
			@RequestParam(name="category",required = false) String category,
			@RequestParam(name="search",required = false) String search,
			Model model) {
		Map<String, Object> map = null;
		if (search==null) {
			//게시글 불러오기
			map = boardService.findAll(page,size);
		}else {
			//게시판 검색
//			System.out.println("검색 : "+category+","+search);
			map = boardService.findContaining(page,size,category,search);
		}
		model.addAttribute("map", map);
		return "blist";
	}//blist-Pageable(page,size)

	//1.전체게시글 불러오기-sort
//	@GetMapping("/board/blist")
//	public String blist(BoardDto boardDto, Model model) {
//		//정렬방법 - bgroup으로 역순,bstep으로 순차<-답글달때 필요
//		Sort sort = Sort.by(
//				Sort.Order.desc("bgroup"),Sort.Order.asc("bstep")
//				);
//		
//		List<BoardDto> list = boardService.findAll(sort);
//		model.addAttribute("list", list);
//		return "blist";
//	}//blist-sort
}
