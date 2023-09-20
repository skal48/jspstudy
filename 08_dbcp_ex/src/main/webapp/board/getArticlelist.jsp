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
  .board span{
    margin-right: 20px;
  }

</style>
<script>
$(function(){
  fnDetail();
})

function fnDetail() {
  $('.board').click(function() {
    location.href = '${contextPath}/board/getArticleDetail.do?board_no=' + $(this).find('.board_no').text();    
  })
}


</script>
</head>
<body>

  <div>
    <a href="${contextPath}/board/writeArticle.do">작성하러가기</a>
  </div>

  <hr>
  <div>
    <c:forEach items="${boardList}" var="board">
      <div class ="board">
        <span class = "board_no"> <a href="${contextPath}/board/plusHit.do">${board.board_no}</a></span>
        <span>${board.title}</span>
        <span>${board.name}</span>
        <span>${board.created_at}</span>
        <span>${board.hit}</span>
      
      </div>
    
    </c:forEach>
  </div>

  <div> ${paging}</div>

</body>
</html>