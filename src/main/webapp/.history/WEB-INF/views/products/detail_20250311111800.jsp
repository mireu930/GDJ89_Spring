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
						<th scope="col">상품번호</th>
			      <th scope="col">상품이름</th>
			      <th scope="col">상품설명</th>
			      <th scope="col">이자율</th>
			      <th scope="col">만기일</th>
			    </tr>
			  </thead>
			  <tbody>
					<c:if test="${not empty dto}">
						<tr>
							<th scope="row">${dto.productNum}</th>
							<td>${dto.productName}</td>
							<td>${dto.productDetail}</td>
							<td>${dto.productRate}</td>
							<td>${dto.productDate}</td>
							<td>${dto.productFileDTO.oldName}</td>
						</tr>
			    </c:if>
			    <c:if test="${empty dto}">
						<h3>정보가 없습니다.</h3>
			    </c:if>
				</tbody>
			</table>
		</div>
		<c:if test="${not empty user}">
			<a href="/accounts/addProcess?prodcutNum=${dto.productNum}" class ="btn btn-outline-success">내계좌추가</a>
			<button type="button" id="addCart" data-product-num="${dto.productNum}" class ="btn btn-outline-secondary">장바구니</button>
		</c:if>
		<div>
			<c:if test="${user.user_name eq 'sss' }">
				<form action="/test" id="frm">
					<input type="hidden" name="productNum" value="${dto.productNum}">
					<button type="button" id="btn1" class="btn btn-outline-success">수정</button>
					<button type="button" id="btn2" class="btn btn-outline-danger">삭제</button>
				</form>
			</c:if>
		</div>		
		<div class="col-12">
			<input type="text" name="boardContents" class="form-control is-invalid" id="productComment">
				<button class="btn btn-primary" type="button" id="commentId" data-comment-boardNum="${dto.productNum}">등록</button>
		</div>
	</div>
	<c:import url="/WEB-INF/views/template/layout_footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/template/boot_js.jsp"></c:import>
	<script src="/resources/JS/products/detail.js"></script>
</body>
</html>