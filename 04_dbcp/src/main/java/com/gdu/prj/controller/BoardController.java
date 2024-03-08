package com.gdu.prj.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.gdu.prj.common.ActionForward;
import com.gdu.prj.service.BoardService;
import com.gdu.prj.service.BoardServiceImpl;

/*
 * view - filter - controller - service - dao - db
 * controller 에서는 service 만 사용가능 dao 코드 x 
 */

public class BoardController extends HttpServlet {
  
	private static final long serialVersionUID = 1L;
	// controller 는 service 를 호출한다
	private BoardService boardService = new BoardServiceImpl();
   	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	  
	  // 요청 주소 확인
	  String requestURI = request.getRequestURI();   /* http://localhost:8080/dbcp/board/list.brd */
	  String contextPath = request.getContextPath(); /*/dbcp */
	  String urlMapping = requestURI.substring(requestURI.indexOf(contextPath) + contextPath.length());
	  
	  // 서비스 메소드 호출 결과를 저장할 ActionForward 객체 선언
	  ActionForward actionForward = null;
	  
	  // 요청 주소에 따른 서비스 메소드 호출
	  switch(urlMapping) {
	  case "/board/list.brd": // 목록 보기 요청
	    actionForward = boardService.getBoardList(request); // 반환값 저장
	    break;
	  case "/board/write.brd":
	    actionForward = new ActionForward("/board/write.jsp", false);
	    break;
	  case "/board/register.brd":
	    actionForward = boardService.addBoard(request);
	    break;
	  case "/main.brd":
	    actionForward = new ActionForward("/index.jsp",false);
	    break;
	  case "/board/detail.brd":
	    actionForward = boardService.getBoardByNo(request);
	    break;
	  case "/board/edit.brd":
	    actionForward = boardService.editBoard(request);
	    break;
	  case "/board/modify.brd":
	    actionForward = boardService.modifyBoard(request);
	    break;
	  case "/board/remove.brd":
	    actionForward = boardService.removeBoard(request);
	  case "/board/removes.brd":
	    actionForward = boardService.removeBoards(request);
	    break;
	  }
	  
	  // 어디로 어떻게 이동
	  if(actionForward != null) {
	    if(actionForward.isRedirect()) {
	      response.sendRedirect(actionForward.getView());
	    } else {
	      request.getRequestDispatcher(actionForward.getView()).forward(request, response);
	    }
	  }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
