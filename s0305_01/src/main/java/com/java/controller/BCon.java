package com.java.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
			@RequestParam(name = "category",required = false) String category,
			@RequestParam(name = "search",required = false) String search,
			@PathVariable(name = "bno",required = false) Integer bno,
			@RequestParam(name = "page",defaultValue = "1") int page,
			Model model) {
		Map<String, Object> map = boardService.findById(bno);
		model.addAttribute("board", map.get("boardDto"));
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
	
	//전체게시글 불러오기-하단넘버링(현재페이지page,페이지당데이터size)
	@GetMapping("/board/blist")
	public String blist(
			@RequestParam(name = "category",required = false) String category,
			@RequestParam(name = "search",required = false) String search,
			@RequestParam(name = "page",defaultValue = "1") int page,
			@RequestParam(name = "size",defaultValue = "10") int size,//페이당 출력게시물 개수
			Model model) {
		
//		System.out.println("Con rcv : "+category+","+search);
		
		//하단넘버링에 필요한 page와 size 전달
		Map<String, Object> map = boardService.findAll(page,size,category,search);
		model.addAttribute("map", map);
		return "blist";
	}
	
	//전체게시글 불러오기-sort
//	@GetMapping("/board/blist")
//	public String blist(BoardDto boardDto, Model model) {
//		
//		
//		List<BoardDto> list = boardService.findAll();
//		model.addAttribute("list", list);
//		return "blist";
//	}
}
