<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>DELETE</title>
<style>
h1 {
		text-align: center;
	}
	
	#deletebox {
		border: black solid 5px;
		width: 400px;
		height: 200px;
		margin: auto;
		text-align: center;
	}
	
	input {

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

	<h1>This is Delete</h1>
	<hr />
	<div id="deletebox">
		<form action="/dbpractice/dbconn/delete" method="POST"><br />
			삭제할 파일의 이름 : <input type="text" name="name"/>
			<input type="submit" value="삭제"  onclick="alert('삭제되었습니다.')" />
		</form>
	</div>
</body>
</html>