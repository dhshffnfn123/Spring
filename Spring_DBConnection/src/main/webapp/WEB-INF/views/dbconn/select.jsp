<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<style>
	div {
		background-color: cornflowerblue;
		height: 30px;
		font-weigth: bolder;
		font-size: 20px;
		width: 500px;
		color: white;
		border: solid 3px black;
		border-radius: 5px;
		box-shadow: black 0 0 10px;
	}
</style>
</head>
<body>

	<h3>this is select</h3>
	<hr />
	
	<c:forEach var="i" items="${person }" varStatus="status">
		<div style="background=red">
			이름 : ${i.name } &nbsp;&nbsp;
			나이 : ${i.age } &nbsp;&nbsp;
			주소 : ${i.address }	&nbsp;&nbsp;
		</div>
			<br>
		
	</c:forEach>
	
	
<%-- 	<c:forEach var="i" begin="0" items="${person }" varStatus="status"> --%>
<%-- 		${status.count } --%>
<%--      	${i} --%>
<%-- 		<c:if test="${(status.count mod 3) eq 0} "> --%>
<!-- 			<br /> -->
<%-- 		</c:if> --%>
<%--    	</c:forEach> --%>
</body>
</html>