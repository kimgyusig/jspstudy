<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <%--
    <c:set> 태그
    1. Bind 영역에 데이터를 저장할 때 사용한다.
    2. 형식
      <c:set var="속성명" value="값" scope="Bind 영역"></c:set>
  --%>
  
  <c:set var="a" value="1" scope="page"></c:set> <%-- setAttribute --%>
  <c:set var="a" value="2" scope="request"></c:set>
  <c:set var="a" value="3" scope="session"></c:set>
  <c:set var="a" value="4" scope="application"></c:set>
  
  <div>${pageScope.a}</div>
  <div>${requestScope.a}</div>
  <div>${sessionScope.a}</div>
  <div>${applicationScope.a}</div>
  
  <%-- 자주 사용하게 될 <c:set> --%>
  <c:set var="contextPath" value="${pageContext.request.contextPath}" scope="page"/>
  <c:set var="contextPath" value="<%=request.getContextPath() %>" /> <%-- scope="page" 생략가능 --%>
  <div>${contextPath}</div>
  

</body>
</html>