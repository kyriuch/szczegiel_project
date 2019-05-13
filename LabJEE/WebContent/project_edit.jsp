<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Projekt</title>
</head>
<body>
	<center>
		<h1>Edycja projektu</h1>
		<h2><a href="ProjektList">Wróć do listy</a></h2>
	</center>
	<div align="center">
	<form method="POST" action="ProjectController?action=processedit">
		<table border="1" cellpadding="5">
			<caption>
				<h2> Edytuj projekt</h2>
			</caption>
			<tr>
				<th>ID:</th>
				<td>${projekt.projectId }<input type="hidden" name="id" size="45" value="${projekt.projectId}"/>
				</td>
			</tr>
			<tr>
				<th>Nazwa projektu:</th>
				<td><input type="text" name="nazwa" size="45" value="${projekt.name}"/>
				</td>
			</tr>
			<tr>
				<th>Opis projektu:</th>
				<td><input type="text" name="opis" size="45" value="${projekt.description}"/></td>
			</tr>
			<tr>
				<th>Data utworzenia:</th>
				<td>${projekt.creationDate}<input type="hidden" type="text" name="data_utworzenia" size="45" value="${projekt.creationDate}" placeholder="yyyy-MM-dd hh:mm:ss"/></td>
			</tr>
			<tr>
				<th>Data oddania:</th>
				<td><input type="text" name="data_obrony" size="45" value="${projekt.returnDate}" placeholder="yyyy-MM-dd"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="Dodaj" />
				</td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>