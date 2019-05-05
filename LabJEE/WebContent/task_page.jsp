<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String info = request.getParameter("x_info");

		if (info != null && info.length() > 0) {
			out.print(info);
		} else {
			out.print("Parametr x_info nie zosta przekazany!");
		}
	%>
	<br />
	<hr />
	<%="Hello World!"%><br /> 
	Data: <%=new SimpleDateFormat("dd-MM-yyyy").format(new Date()) %><br/>
	ID Studenta: <%=request.getParameter("x_student_id")%><br/>
	Informacja przekierowana z serwletu: <%= request.getAttribute("x_redirect")%>
	
</body>
</html>