<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	h1 {
		text-align: center;
	}
	
	#insertbox {
		border: black solid 5px;
		width: 400px;
		height: 200px;
		margin: auto;
		text-align: center;
	}
	
	input {
/* 		position:relative; */
/* 		left:100px; */
		margin-bottom: 20px;
	}
	
	input:first-child {
		margin-top: 35px;
	}
	
	input:last-child {
		width:100px;
		height: 30px;
		background-color: white;
		border: solid 3px black;
		cursor: pointer;
	}
	
	input:last-child:active {
		background-color: black;
		color: white;
	}
</style>
</head>
<body>

	<h1>this is insert</h1>
	
	<hr />
	
	<div id="insertbox">
		<form action="/dbpractice/dbconn/insert" method="POST">
			이름 : <input type="text" name="name" /><br />
			나이 : <input type="text" name="age" /> <br />
			주소 : <input type="text" name="address" /> <br />
			<input type="submit" value="등록" onclick="alert('${name}가 등록되었습니다.')">
		</form>
	</div>

</body>
</html>








