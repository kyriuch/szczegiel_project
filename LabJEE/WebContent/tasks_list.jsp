<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista zadań</title>
</head>
<body>

		<center>
		<h1>Lista zadań</h1>
		<h2><a href="ProjektList">Wróć do listy</a></h2>
	</center>
	<table border="1" cellpadding="3">
		<tr>
			<th>Lp.</th>
			<th>Id</th>
			<th>Nazwa</th>
			<th>Opis</th>
			<th>Koleność</th>
			<th>Data oddania</th>
		</tr>
		<c:forEach var="zadanie" items="${requestScope.tasks}"
			varStatus="info">
			<tr>
				<td>${info.count}.</td>
				<td><c:out value="${zadanie.taskId}" /></td>
				<td><c:out value="${zadanie.name}" /></td>
				<td><c:out value="${zadanie.description}" /></td>
				<td><c:out value="${zadanie.order}" /></td>
				<javatime:format value="${zadanie.returnTime}"
					var="fmtReturnTime" pattern="yyyy-MM-dd hh:mm:ss" />
				<td><c:out value="${fmtReturnTime}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>