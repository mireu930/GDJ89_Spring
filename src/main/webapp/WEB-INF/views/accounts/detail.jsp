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
			      <td>${dto.accountsBalance}</td>
			      <td>${dto.accountDate}</td>
			    </tr>
			    </c:if>
			    <c:if test="${empty dto}">
			     <h3>정보가 없습니다.</h3>
			    </c:if>
			     </tbody>
			</table>
		</div>	
		<div>
			<form action="/test" id="frm">
			<input type ="hidden" name="accountNum" value="${dto.accountNum}">
				<button type="button" class ="btn btn-outline-danger" id="btn2">삭제</button>	
			</form>
		</div>
		</div>
	<script src="/resources/JS/accounts/detail.js"></script>
	<c:import url="/WEB-INF/views/template/layout_footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/template/boot_js.jsp"></c:import>
</body>
</html>