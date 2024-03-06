<%@page import="java.time.LocalDateTime"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


  <div>
    <div>
      <select>
        <option id="id1">현재날짜</option>
        <option id="id2">현재시간</option>
      </select>
    </div>
    <div>
      <button type="button" id="btn1">요청하기</button>
    </div>
  </div>
  <script>
  <% 
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String result = sdf.format(date);
    %>
  const prdate = document.getElementById('id1');
  const prtime = document.getElementById('id2');
  const pracFn = (evt)=>{
	  if(prdate.textContent =='현재날짜' ){ 
		  alert('요청결과는'+<%=LocalDate.now()%> + '입니다');
	  } else {
		  alert('요청결과는' + <%=LocalDateTime.now() %>);
	  }
  }
    document.getElementById('btn1').addEventListener('click', pracFn);
  </script>

</body>
</html>