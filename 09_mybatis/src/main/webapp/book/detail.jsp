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
  .link a {
    margin-right: 20px;
  }
</style>
<script>

  $(function(){
    fnDelete();
  })

  function fnDelete(){
    $('#delete_link').click(function(event){
      if(!confirm('게시글을 삭제할까요?')){
        event.preventDefault();
        return;
      }
    })
  }

</script>
</head>
<body>

  <div class="link">
    <a href="${contextPath}/book/write.do">작성하러가기</a>
    <a href="${contextPath}/book/list.do">목록으로이동</a>
    <a href="${contextPath}/book/edit.do?book_no=${book.book_no}">수정하러가기</a>
    <a id="delete_link" href="${contextPath}/book/delete.do?book_no=${book.book_no}">삭제하기</a>
  </div>

  <hr>
  
  <div>
    <div>게시글번호: ${book.book_no}</div>
    <div>제목: ${book.title}</div>
    <div><pre>${book.content}</pre></div>
    <div>최종수정일: ${book.modified_at}</div>
    <div>최초작성일: ${book.created_at}</div>
  </div>

</body>
</html>