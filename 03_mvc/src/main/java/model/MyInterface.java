package model;

import common.ActionForward;
import jakarta.servlet.http.HttpServletRequest;

public interface MyInterface {
  ActionForward getDate(HttpServletRequest request);
  ActionForward getTime(HttpServletRequest request);
  ActionForward getDateTime(HttpServletRequest request);
}
