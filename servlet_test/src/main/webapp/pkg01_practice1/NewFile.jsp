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
      <h4>아이디</h4>
      <input type="text" id="id1">@naver.com
    </div>
    <div>
      <h4>비밀번호</h4>
      <input type="password" id="id2">   
    </div>
    <div>
      <h4>생년월일</h4>
      <input type="text" placeholder="년(4자)">
     <select name="month">
       <option>월</option>
       <% for(int m=1; m <=12; m++) { %>
       <option><%=m%></option>
       <% } %>
     </select>
     <input type="text" placeholder="일">
    </div>
    <div>
    <h4>성별</h4>
      <select>
        <option >성별</option>
        <option >남자</option>
        <option >여자</option>
      </select>
    </div>
    <div>
      <h4>본인 확인 이메일(선택)</h4>
      <input type="text">
    </div>
    <div>
      <h4>휴대전화</h4>
      <select>
      <option value=>+82한국</option>
      </select>
    </div>
    <div>
      <input type="text">
      <button type="button">인증번호 받기</button>   
    </div>
    <div>
      <input type="text" placeholder="인증번호를 입력하세요">
    </div>
    <div>
      <button type="button" id="btn1">가입하기</button>
    </div>
    
  </div>

  <script>
  
	const idCk = document.getElementById('id1');
	const pwCk = document.getElementById('id2');
  const pracFn = ()=>{
	  if(idCk.value === ''){
		  alert('아이디는 필수입니다');
	  }
	  if(pwCk.value !== '1111') {
		  alert('비밀번호를 확인하세요');
	  }
	  
	  
  };
  
  
  
    document.getElementById('btn1').addEventListener('click', pracFn); 
  
  </script>









</body>
</html>