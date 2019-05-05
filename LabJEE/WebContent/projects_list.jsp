<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista projektów</title>
</head>
<body>
	<form action="ProjektList" method="POST">
		<h2>Wyszukaj</h2>
		<input name="project_id" type="number" placeholder="Id projektu"/>
		<input name="project_name" type="text" placeholder="Nazwa projektu"/>
		Elementów na stronę: 
		<select name="list_count">
			<option value="0" selected>5</option>
			<option value="1">10</option>
			<option value="2">15</option>
			<option value="3">20</option>
		</select>
		<input name="btn_list" value="Wyszukaj" type="submit">
	</form>
	<h2>Lista projektów</h2>
	<table border="1" cellpadding="3">
		<tr>
			<th>Lp.</th>
			<th>Id</th>
			<th>Nazwa</th>
			<th>Opis</th>
			<th>Utworzony</th>
			<th>Data obrony</th>
			<th>Edycja</th>
		</tr>
		<c:forEach var="projekt" items="${requestScope.projects}"
			varStatus="info">
			<tr>
				<td>${info.count}.</td>
				<td><c:out value="${projekt.projectId}" /></td>
				<td><c:out value="${projekt.name}" /></td>
				<td><c:out value="${projekt.description}" /></td>
				<javatime:format value="${projekt.creationDate}"
					var="fmtDataczasUtworzenia" pattern="yyyy-MM-dd hh:mm:ss" />
				<td><c:out value="${fmtDataczasUtworzenia}" /></td>
				<javatime:format value="${project.returnDate}" var="fmtDataOddania"
					pattern="yyyy-MM-dd" />
				<td><c:out value="${fmtDataOddania}" /></td>
				<c:url value="/pages/zadania.jsp" var="linkZadaniaProjektu">
					<c:param name="x_projekt_id" value="${projekt.projectId}" />
				</c:url>
				<td><a href='<c:out value="${linkZadaniaProjektu}" />'>Zadania</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>