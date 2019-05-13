<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Projekt</title>
</head>
<body>
	<center>
		<h1>Dodaj projekt</h1>
		<h2><a href="ProjektList">Wróć do listy</a></h2>
	</center>
	<div align="center">
	<form method="POST" action="ProjectController?action=add">
		<table border="1" cellpadding="5">
			<caption>
				<h2> Dodaj projektv</h2>
			</caption>
			<tr>
				<th>Nazwa projektu:</th>
				<td><input type="text" name="nazwa" size="45"/>
				</td>
			</tr>
			<tr>
				<th>Opis projektu:</th>
				<td><input type="text" name="opis" size="45"/></td>
			</tr>
			<tr>
				<th>Data oddania:</th>
				<td><input type="text" name="data_obrony" size="45" placeholder="yyyy-MM-dd"/></td>
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