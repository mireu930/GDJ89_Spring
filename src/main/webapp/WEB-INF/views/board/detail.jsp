<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<c:import url="/WEB-INF/views/template/boot_css.jsp"></c:import>
</head>
<body>
	<c:import url="/WEB-INF/views/template/layout_header.jsp"></c:import>
	<div class = "container-fluid my-5">
		<div class = "row col-md-8 offset-md-2">
			<h1>${kind}DetailPage</h1>
			<table class="table table-striped table-hover">
		 		<thead>
			    <tr>
			      <th scope="col">제목</th>
			      <th scope="col">내용</th>
			      <th scope="col">작성자</th>
			      <th scope="col">조회수</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:if test="${not empty dto}">
			    <tr>
			      <th scope="row">${dto.boardTitle}</th>
			      <td>${dto.boardContent}</td>
			      <td>${dto.user_name}</td>
			      <td>${dto.boardHit}</td>
			    </tr>
			    </c:if>
			    <c:if test="${empty dto}">
			     <h3>정보가 없습니다.</h3>
			    </c:if>
			     </tbody>
			</table>
		</div>
			<a href="./update?boardNum=${dto.boardNum}" class ="btn btn-outline-success">수정</a>	
			<a href="./delete?boardNum=${dto.boardNum}" class ="btn btn-outline-danger">삭제</a>
			<c:if test="${kind eq 'QnA'}">
			<a href="./reply?boardNum=${dto.boardNum}" class ="btn btn-outline-primary">댓글쓰기</a>
			</c:if>
	
	</div>
	<c:import url="/WEB-INF/views/template/layout_footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/template/boot_js.jsp"></c:import>
</body>
</html>