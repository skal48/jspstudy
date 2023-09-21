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
<script>

  $(function(){
    // 함수 호출
    fnbookList();
    fnbookRegister1();
    fnbookRegister2();
    fnbookRegister3();
  })

  // 함수 정의
  function fnbookList(){
    $('#btn_list').click(function(){  
      location.href = '${contextPath}/book/list.do';
    })
  }
  // 함수 정의
  function fnbookRegister1(){
    $('#frm_register').submit(function(event){
      if($('#title').val() === ''){
        alert('책 제목은 필수입니다.');
        $('#title').focus();
        event.preventDefault();
        return;
      }
    })
  }
  function fnbookRegister2(){
    $('#frm_register').submit(function(event){
      if($('#author').val() === ''){
        alert('저자는 필수입니다.');
        $('#title').focus();
        event.preventDefault();
        return;
      }
    })
  }
  function fnbookRegister3(){
    $('#frm_register').submit(function(event){
      if($('#price').val() === ''){
        alert('책 가격은 필수입니다.');
        $('#title').focus();
        event.preventDefault();
        return;
      }
    })
  }

</script>
</head>
<body>

<div>
  <form id="frm_register" method="post" action="${contextPath}/book/register.do">
    <div>
      <label for="title">제목</label>
      <input type="text" id="title" name="title">
    </div>
     <div>
      <label for="author">저자</label>
      <input type="text" id="author" name="author">
    </div>
     <div>
      <label for="price">책 가격</label>
      <input type="text" id="price" name="price">
    </div>
    <div>
      <button type="submit">작성완료</button>
      <button type="reset">작성초기화</button>
      <button type="button" id="btn_list">목록으로이동</button>
    </div>
  </form>
</div>

</body>
</html>