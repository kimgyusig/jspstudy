<%@page import="java.time.LocalDate"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileWriter"%>
<%@page import="java.io.BufferedWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <style>
    #content {
    height: 100px;
    width: 300px
    
    
    }
  </style>
</head>
<body>

  <%String contextPath = request.getContextPath(); %>

 <form method="POST"
       action="<%=contextPath%>/pkg04_practice4/save.jsp">
  <div class="cs1">
  <div>
    <label for="wri">작성자</label>
    <input type="text" name="wri" id="wri">
  </div>
  <div>
    <label for="title">제목</label>
    <input type="text" name="title" id="title">
  </div>
  <div>
    <input type="text" placeholder="내용" name="content" id="content">
  </div>
  <div>
  <button type="submit" id="btn1">작성완료</button>
  <button type="reset">작성초기화</button>
  </div>
  </div>
 </form>
 
 
 
 

  <script>
  
 
  </script>




</body>
</html>