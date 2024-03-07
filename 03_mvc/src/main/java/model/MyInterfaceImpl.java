package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import common.ActionForward;
import jakarta.servlet.http.HttpServletRequest;

public class MyInterfaceImpl implements MyInterface {

  @Override
  public ActionForward getDate(HttpServletRequest request) {
    //  request 에 데이터저장하고 forward로 보냄 return 은 jsp 이름  결과는 jsp 로 보냄 정보를 가지고 가야해서 forward
    request.setAttribute("date", DateTimeFormatter.ofPattern("yyyy.MM.dd.").format(LocalDate.now()));
    return new ActionForward("/view/date.jsp", false); // forward 는 정보가 request 에 전부 저장 응답은 데이터 저장을할 수 없다.
  }

  @Override
  public ActionForward getTime(HttpServletRequest request) {
    request.setAttribute("time", DateTimeFormatter.ofPattern("HH:mm:ss.SSS").format(LocalTime.now()));
    return new ActionForward("/view/time.jsp", false);
  }

  @Override
  public ActionForward getDateTime(HttpServletRequest request) {
    request.setAttribute("datetime", DateTimeFormatter.ofPattern("yyyy. MM. dd. HH:mm:ss.SSS").format(LocalDateTime.now()));
    return new ActionForward("/view/datetime.jsp", false);
  }

}
