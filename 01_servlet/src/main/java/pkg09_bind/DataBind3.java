package pkg09_bind;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class DataBind3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    /*
     * 데이터 저장 영역
     * 
     * 1. ServletContext     : 컨텍스트 종료(애플리케이션 실행 종료) 전까지 데이터를 유지한다.
     * 2. HttpSession        : 세션 종료(웹 브라우저 종료) 전까지 데이터를 유지한다.
     * 3. HttpServletRequest : 요청 종료(응답) 전까지 데이터를 유지한다.
     */
    
    /*
     * 데이터 처리 메소드
     * 1. setAttribute(속성, 값) : Object 타입의 값을 저장한다.
     * 2. getAttribute(속성)     : Object 타입의 값을 반환한다. (캐스팅이 필요할 수 있다).
     * 3. removeAttribute(속성)  : 제거한다.
     */
    
    // HttpServletRequset에 데이터 저장하기
    request.setAttribute("c", "일반데이터");  // request 에 데이터 저장하고 forward 로 보낸다
    
    // 데이터 확인 페이지로 이동하기
    //response.sendRedirect("/servlet/dataConfirm"); Redirect 는 요청이 두번이여서 확인 불가능
    request.getRequestDispatcher("/dataConfirm").forward(request, response); //forward 는 값을 그대로 전달
    
  }


  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }


}
