<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ProjektDelete" method="POST">
		<input name="project_id" type="number" placeholder="Id projektu">
		<input name="btn_usun" value="Usun" type="submit">
	</form>
	
	Nazwa usuniętego projektu: ${ requestScope.project_name }
</body>
</html>