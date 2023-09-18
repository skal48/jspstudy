<%@page import="java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
  request.setCharacterEncoding("UTF-8");
  Optional<String> opt = Optional.ofNullable(request.getParameter("title"));
  String title = opt.orElse("환영합니다");
  String contextPath = request.getContextPath();
%>
<title><%=title%></title>
<script src="<%=contextPath %>/resource/js/lib/jquery-3.7.1.min.js"></script>
<script src="<%=contextPath %>/resource/js/header.js?dt=<%=System.currentTimeMillis()%>"></script> 
<link rel="stylesheet" href="/jsp/resource/css/header.css?dt=<%=System.currentTimeMillis()%>"> <!-- cache 를 해야지 CSS 적용됨. 프로젝트가 달라지면 폴더 구조가 바뀔수 있음 어셈블리 확인해라 -->
<link rel="stylesheet" href="/jsp/resource/css/main.css?dt=<%=System.currentTimeMillis()%>">
<link rel="stylesheet" href="/jsp/resource/css/footer.css?dt=<%=System.currentTimeMillis()%>">
</head>
<body>

  <nav class="gnb">
    <div class="logo"></div>
    <ul>
      <li> <a href="main1.jsp">main1</a> </li>
      <li> <a href="main2.jsp">main2</a> </li>
      <li> <a href="main3.jsp">main3</a> </li>
    </ul>  
  </nav>
  
</body>
</html>