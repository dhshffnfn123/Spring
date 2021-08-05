<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body>

<h3># 연습문제</h3>
<ul>
   <li>다양한 회원 정보를 입력받는다. (생일 포함)</li>
   <li>POST방식으로 회원정보와 함께 요청하면 전달한 회원 정보를 서버의 /data/user에 파일 형태로 저장한다.</li>
   <li>파일 이름은 중복이 생기지 않도록 조심해야 한다.</li>
   <li>누락된 정보가 있는 경우 회원가입 실패 페이지로 넘어가야 한다.</li>
   <li>회원가입에 성공하면 회원가입 성공페이지를 5초간 보여준 후 다시 홈으로 이동한다.</li>
</ul>

<hr>

<form action="<c:url value="/hello/join"/>" method="POST">
   ID : <input type="text" name="id"> <br>
   PW : <input type="password" name="password"> <br>
   이름: <input type="text" name="name"> <br>
   나이: <input type="number" name="age"> <br>
    생일: <input type="date" name="birthday"> <br>
   <input type="submit" value="회원가입">
</form>




</body>
</html>
	<!-- 
	<div id="box">
		<div id="innerbox">
		<form action="./joininfo"  method="POST" accept-charset="UTF-8">
      <p>
         <label for="userId">아이디 </label> 
         <input type="text" id="userId" name="userId" />
      </p>
      <p>
         <label for="userPass">비밀번호</label>
          <input type="password" id="userPass" name="userPass" />
      </p>
      <p>
         <label for="userName">이름</label>
          <input type="text" id="userName" name="userName" />
      </p>
      <p>
         <label for="userBirth">생년월일</label>
          <input type="date" id="userBirth" name="userBirth" />
      </p>
      <p>
         <button type="submit">회원가입</button>
      </p>
   </form>
  		</div>
	</div> 	
	
</body>
</html>
	 -->













