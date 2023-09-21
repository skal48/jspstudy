<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="<%=request.getContextPath()%>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<style>
  .book span {
    margin-right: 20px;
  }
</style>
<script>

  $(function(){
    fnDetail();
  })

  function fnDetail(){
    $('.book').click(function(){
      location.href = '${contextPath}/book/detail.do?book_no=' + $(this).find('.book_no').text();
    })
  }

</script>
</head>
<body>

  <div>
    <a href="${contextPath}/book/write.do">등록하러가기</a>
  </div>

  <hr>
  
  <div>
    <c:forEach items="${bookList}" var="book">
      <div class="book">
        <span class="book_no">${book.book_no}</span>
        <span>${book.title}</span>
        <span>${book.author}</span>
        <span>${book.price}</span>
        <span>${book.created_at}</span>
      </div>
    </c:forEach>
  </div>
  
  <div>${paging}</div>

</body>
</html>