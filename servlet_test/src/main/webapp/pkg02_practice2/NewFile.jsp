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
  <button type="reset" id="btn1">새로고침</button>
  </div>
   <div>
   <%=getRandom()%>
  <input type="text" id="id1">
  <button type="button" id="btn2">계산</button>
  </div>
  </div>
  
  
  <script>
  
  document.getElementById('btn1').addEventListener('click', function(){
	  <%! public int getRandom(){
		    int a = (int)Math.random() *9 +2;
		    int b = (int)Math.random() *9 +1;
		    int result = a *b;
		    return result;
		    }
		    %>
  });
	  
    
   
  
  </script>

</body>
</html>