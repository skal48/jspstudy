<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


  <%--
  
      <c:if>
      1. if 문이다. 
      2. else 문이 없다. 
      3. 형식
        <c:if test="조건식">
          실행문
        </c:if>     
   --%>
   
   <c:set var="age" value= "30" />
   <c:if test="${age >= 20}">
    <div>성인</div>   
   </c:if>
   <c:if test="${age < 20}">
    <div>미성년자</div>
   </c:if>
   
   
   <c:set var="score" value="75" />
   <c:if test="${100 >= score and score >= 90 }"> <c:set var= "grade" value= "A"/></c:if>
   <c:if test="${90 >= score and score > 80 }">  <c:set var= "grade" value= "B"/></c:if>
   <c:if test="${80 >= score and score > 70 }">  <c:set var= "grade" value= "C"/></c:if>
   <c:if test="${70 >= score and score > 60 }">  <c:set var= "grade" value= "D"/></c:if>
   <c:if test="${60 >= score }">  <c:set var= "grade" value= "F"/></c:if>
   <div>${score}점, ${grade}학점</div>



</body>
</html>