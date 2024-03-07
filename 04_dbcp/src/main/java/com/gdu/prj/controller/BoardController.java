package com.gdu.prj.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.gdu.prj.service.BoardService;
import com.gdu.prj.service.BoardServiceImpl;

/*
 * view - controller - service - dao - db
 * controller 에서는 service 만 사용가능 dao 코드 x 
 */

public class BoardController extends HttpServlet {
  
	private static final long serialVersionUID = 1L;
	// controller 는 service 를 호출한다
	private BoardService boardService = new BoardServiceImpl();
   	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	  
	  
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
