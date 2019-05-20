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
		<input name="project_id" type="number" placeholder="Id projektu"
			value="<%=request.getAttribute("pId")%>" /> <input
			name="project_name" type="text" placeholder="Nazwa projektu"
			value="<%=request.getAttribute("projectName") == null ? "" : request.getAttribute("projectName")%>" />
		Elementów na stronę: <select name="list_count">
			<option value="0"
				<c:if test="${requestScope.list_count eq 5}">selected</c:if>>5</option>
			<option value="1"
				<c:if test="${requestScope.list_count eq 10}">selected</c:if>>10</option>
			<option value="2"
				<c:if test="${requestScope.list_count eq 15}">selected</c:if>>15</option>
			<option value="3"
				<c:if test="${requestScope.list_count eq 20}">selected</c:if>>20</option>
		</select>
		<c:if test="${requestScope.page_number != 1}">
			<input name="prev" value="Back" type="submit">
		</c:if>
		<input name="page_number" type="hidden" value="<%=request.getAttribute("page_number")%>" /> 
		<input name="btn_list" value="Wyszukaj" type="submit" />
		<input name="next" value="Next" type="submit">
	</form>
	
	<a href="index.html"><h3>Chat</h3></a>

	<h2>Lista projektów</h2>
	<a href="project_form.jsp"><h3>Dodaj projekt</h3></a>
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
				<javatime:format value="${projekt.returnDate}" var="fmtDataOddania"
					pattern="yyyy-MM-dd" />
				<td><c:out value="${fmtDataOddania}" /></td>
				<td><a href="TasksList?id=${projekt.projectId}">Zadania</a></br> 
					<a href="room/${projekt.projectId}">Czat</a></br>
					<a href="ProjectController?action=edit&id=${projekt.projectId}">Edycja</a></br>
					<a href="ProjectController?action=delete&id=${projekt.projectId}"
					onClick="return confirm('Na pewno chcesz usunąć projekt?')">Usuń</a></br>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>