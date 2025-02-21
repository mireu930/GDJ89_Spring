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
			<h1>detail</h1>
			<table class="table table-striped table-hover">
		 		<thead>
			    <tr>
			      <th scope="col">계좌번호</th>
			      <th scope="col">상품번호</th>
			      <th scope="col">잔액</th>
			      <th scope="col">등록날짜</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:if test="${not empty dto}">
			    <tr>
			      <th scope="row">${dto.accountNum}</th>
			      <td>${dto.productNum}</td>
			      <td>${dto.accountBalance}</td>
			      <td>${dto.accountDate}</td>
			    </tr>
			    </c:if>
			    <c:if test="${empty dto}">
			     <h3>정보가 없습니다.</h3>
			    </c:if>
			     </tbody>
			</table>
		</div>
			<a href="./update?accountNum=${dto.accountNum}" class ="btn btn-outline-success">수정</a>	
			<a href="./delete?accountNum=${dto.accountNum}" class ="btn btn-outline-danger">삭제</a>	
	</div>
	<c:import url="/WEB-INF/views/template/layout_footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/template/boot_js.jsp"></c:import>
</body>
</html>