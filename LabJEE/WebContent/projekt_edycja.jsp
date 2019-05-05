<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ProjektEdycja" method="POST">
		<input name="btn_zapisz" value="Zapisz projekt" type="submit">
	</form>
	
	ID Zapisanego Projektu: ${ requestScope.project.projectId }
</body>
</html>