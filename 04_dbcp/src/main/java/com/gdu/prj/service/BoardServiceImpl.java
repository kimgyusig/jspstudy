package com.gdu.prj.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.gdu.prj.common.ActionForward;
import com.gdu.prj.dao.BoardDao;
import com.gdu.prj.dao.BoardDaoImpl;
import com.gdu.prj.dto.BoardDto;
import com.gdu.prj.utils.MypageUtils;

import jakarta.servlet.http.HttpServletRequest;

/*
 * view - filter - controller - service - dao - db
 * service 에서는 dao 만 가능
 */

public class BoardServiceImpl implements BoardService {
  // service 는 dao 를 호출한다.
  private BoardDao boardDao = BoardDaoImpl.getInstance();
  
  // 목록 보기는 MyPageUtils 객체가 필요하다
  private MypageUtils mypageUtils = new MypageUtils();
  
  @Override
  public ActionForward addBoard(HttpServletRequest request) {
    String title = request.getParameter("title");
    String contents = request.getParameter("contents");  // insertBoard 로 넘길때 BoardDto 타입으로
    BoardDto board = BoardDto.builder()
                        .title(title)
                        .contents(contents)
                      .build();
    int insertCount = boardDao.insertBoard(board);
    // redirect 경로는 URLMapping 으로 작성한다.
    String view = null;
    if(insertCount == 1) {
      view = request.getContextPath() + "/board/list.brd";
    } else if(insertCount == 0) {
      view = request.getContextPath() + "/main.brd";
    }
    // INSERT  이후 이동은 redirect 
    return new ActionForward(view,true);
  }

  @Override
  public ActionForward getBoardList(HttpServletRequest request) {
    
    // 전체 게시글 개수 
    int total = boardDao.getBoardCount();
    
    // 한 페이지에 표할 게시글 개수
    Optional<String> optDisplay =  Optional.ofNullable(request.getParameter("display"));
    int display = Integer.parseInt(optDisplay.orElse("20"));  // 파라미터가 전달 되지 않으면 20을 꺼내쓴다
    
    // 현재 페이지 번호
    Optional<String> optPage = Optional.ofNullable(request.getParameter("page"));
    int page = Integer.parseInt(optPage.orElse("1"));
    
    // 정렬 방식
    Optional<String> optSort = Optional.ofNullable(request.getParameter("sort"));
    String sort = optSort.orElse("DESC");
        
    // 페이징 처리에 필요한 변수 값 계산하기
    mypageUtils.setPaging(total, display, page);
    
    // 목록을 가져올 때 필요한 변수를 Map 에 저장함
    Map<String, Object> params = Map.of("begin", mypageUtils.getBegin(),
                                         "end", mypageUtils.getEnd(),
                                         "sort",sort);
    
    // 목록 가져오기
    List<BoardDto> boardList = boardDao.selectBoardList(params);
    
    // 페이지 링크 가져오기
    String paging = mypageUtils.getPaging(request.getRequestURI(), sort, display); // /dbcp/board/list.brd
    
    // JSP 에 전달할 데이터들
    request.setAttribute("total", total); // request 객체 에 저장
    request.setAttribute("boardList", boardList);  // request 객체 에 저장
    request.setAttribute("paging", paging);
    request.setAttribute("display", display);
    request.setAttribute("sort", sort);
    
    return new ActionForward("/board/list.jsp",false); // forward 로 request 저장 값도 같이 보낸다 false 가 forward
  }

  @Override
  public ActionForward getBoardByNo(HttpServletRequest request) {
    Optional<String> opt = Optional.ofNullable(request.getParameter("board_no"));
    int board_no = Integer.parseInt(opt.orElse("0"));
    BoardDto board = boardDao.selectBoardByNo(board_no);
    String view = null;
    if(board != null) {
      view = "/board/detail.jsp";
      request.setAttribute("board", board);
    } else {
      view = "/index.jsp";
    }
    return new ActionForward(view, false);
  }

  @Override
  public ActionForward editBoard(HttpServletRequest request) { // 게시글의 번호를 가지고 편집 화면으로 간다
    String param = request.getParameter("board_no");
    int board_no = 0;
    if(! param.isEmpty()) {
      board_no = Integer.parseInt(param);
    }
    BoardDto board = boardDao.selectBoardByNo(board_no);
    String view = null;
    if(board != null) {
      view = "/board/edit.jsp";
      request.setAttribute("board", board);
    } else {
      view = "/index.jsp";
    }
    return new ActionForward(view, false); //  select board 라는 이름으로해서 편집화면으로 보낸다
  }

  @Override
  public ActionForward modifyBoard(HttpServletRequest request) {
    int board_no = Integer.parseInt(request.getParameter("board_no")) ;
    String title = request.getParameter("title");
    String contents = request.getParameter("contents");
    BoardDto board = BoardDto.builder()
                             .title(title)
                             .contents(contents)
                             .board_no(board_no)
                           .build();
    int updateCount = boardDao.updateBoard(board);
    String view = null;
    if(updateCount == 0) {
      view = request.getContextPath() + "/main.brd";
    } else {
      view = request.getContextPath() + "/board/detail.brd?board_no=" + board_no;
    }          
    return new ActionForward(view,true);
  }

  @Override
  public ActionForward removeBoard(HttpServletRequest request) {
    String param = request.getParameter("board_no");
    int board_no =0;
    if(!param.isEmpty()) {
      board_no = Integer.parseInt(param);
    }
    int deleteCount = boardDao.deleteBoard(board_no);
    String view = null;
    if(deleteCount == 0) {
      view = request.getContextPath() + "/main.brd";
    } else {
      view = request.getContextPath() + "/board/list.brd";
    }
    return  new ActionForward(view,true);
  }

  @Override
  public ActionForward removeBoards(HttpServletRequest request) {
    String param = request.getParameter("param");
    int deleteCount = boardDao.deleteBoards(param);
    String view = null;
    if(deleteCount == 0) {
      view = request.getContextPath() + "/main.brd";
    } else {
      view = request.getContextPath() + "/board/list.brd";
    }
    return new ActionForward(view, true);
  }
  
}
