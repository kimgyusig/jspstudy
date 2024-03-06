<%@page import="java.io.FileWriter"%>
<%@page import="java.io.BufferedWriter"%>
<%@page import="java.io.File"%>
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

  <% request.setCharacterEncoding("UTF-8"); %>
  
  <%
    String wri = request.getParameter("wri");
    String title = request.getParameter("title");
    String content = request.getParameter("content");
    
    String uploadPath = application.getRealPath("upload");
    File uploadDir = new File(uploadPath);
    if(! uploadDir.exists()){
      uploadDir.mkdirs();
    }
    
    String uploadName =  LocalDate.now() + wri + title + ".txt";
    File uploadFile = new File(uploadDir, uploadName);
    
    BufferedWriter writer = new BufferedWriter(new FileWriter(uploadFile));
    
   writer.write(wri);
   writer.write(title);
   writer.write(content);
    

  %>
  <script>
  
  
  </script>

</body>
</html>