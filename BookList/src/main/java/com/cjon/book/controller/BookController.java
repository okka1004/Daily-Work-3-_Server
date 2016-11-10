package com.cjon.book.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cjon.book.dto.BookDTO;
import com.cjon.book.service.BookSearchKeywordList;
import com.cjon.book.service.BookService;

@Controller
public class BookController {

	@RequestMapping("/bookList")
	//JSONP방식으로 JSON데이터를 보내줄꺼예요
	public void getBookList(HttpServletRequest request, HttpServletResponse response){
		
		System.out.println("여기는 들어와??");
		
		String keyword = request.getParameter("keyword");
		String callback = request.getParameter("callback");
		
		System.out.println("나는"+keyword);
		
		BookDTO dto = new BookDTO();
		dto.setBtitle(keyword);
		
		System.out.println("키워드는 "+dto.getBtitle());
		
		//서비스 객체 생성
		BookService service = new BookSearchKeywordList();//왜 이렇게 쓰는걸까? 왜 타입을 상위타입을 쓰는거지?
		String result = service.execute(dto);
		
		//System.out.println("나의 result는"+result);
		
		response.setContentType("text/plain; charset=utf8");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println(callback+"("+result+")");
			System.out.println(callback+"("+result+")");
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	
}
