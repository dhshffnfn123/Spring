<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3> # CRUD 연습에 사용했던 테이블을 통해 다음을 만들어주세요</h3>
	
	<ul>
		<li>갱신 버튼을 누르면 페이지가 변하지 않으면서 CRUD 테이블의 모든 내용을 display 테이블에 출력한다</li>
		<li>
			display 테이블의 맨 윗줄에는 새로운 행을 추가할 수 있는 입력란이 존재하고 추가 버튼을 누르면 페이지가 변하지
			않으면서 추가와 함께 테이블 목록이 갱신된다
		</li>
		<li>
			display 테이블의 데이터 행의 맨 오른쪽에는 삭제버튼이 존재하며 
			삭제버튼을 누르면 해당 행이 삭제되며 테이블 목록이 갱신된다
		</li>
	</ul>
	
	<hr />
	
	<table id="display" border="3">
		<tr>
			<td>TEST</td>		
			<td>TSET</td>
			<td>STET</td>
		</tr>
	</table>
	
	<button id="selectBtn">Person의 모든 정보 조회</button>
	<script src="<%=request.getContextPath() %>/resources/js/person_home.js"></script>
	

</body>
</html>