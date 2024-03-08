package com.gdu.prj.service;

import com.gdu.prj.common.ActionForward;

import jakarta.servlet.http.HttpServletRequest;

public interface BoardService {
  ActionForward addBoard(HttpServletRequest request); // insert
  ActionForward getBoardList(HttpServletRequest request);// 목록보기
  ActionForward getBoardByNo(HttpServletRequest request); // 상세보기
  ActionForward editBoard(HttpServletRequest request); //수정화면
  ActionForward modifyBoard(HttpServletRequest request); // 데이터베이스 수정
  ActionForward removeBoard(HttpServletRequest request);
  ActionForward removeBoards(HttpServletRequest request);
}
