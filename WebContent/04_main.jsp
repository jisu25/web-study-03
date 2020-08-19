<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<b><%=request.getParameter("name") %> </b>안녕하세요!<br>
사랑해  <%=request.getParameter("name") %>ㅠㅠ
</body>
</html>