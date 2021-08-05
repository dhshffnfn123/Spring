<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2># AJAX를 사용해 봅시다</h2>

	<ul>
		<li>페이지가 모두 로드되고 난 후에 서버로 데이터를 요청할 수 있습니다</li>
		<li>페이지를 다시 로딩할 필요없이 업데이트 할 수 있습니다!</li>
		<li>백그라운드로 서버로 데이터를 전송할 수 있습니다!</li>
	</ul>
	
	<hr />
	
	<div id="test">
		<h4>받아온 데이터를 이곳에 출력할 예정</h4>
	</div>
	
	<button onclick="loadStr()">getStr()에서 데이터 가져오기</button> <br /><br />
	<button id="sampleAsyncBtn" >getSample()에서 데이터 가져오기</button> <br /> <br />
	<button id="asyncJsonDataBtn" >JSON 데이터와 함께 비동기 요청 보내기</button>
	
	<!-- 서버의 자원을 사용할 때는 servlet-context의 자원 경로를 사용해야 한다 -->
	<script src="<%=request.getContextPath() %>/resources/js/ajax_home.js"></script>

</body>
</html>





















