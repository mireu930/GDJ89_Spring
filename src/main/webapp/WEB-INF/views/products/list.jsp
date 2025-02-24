<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot_css.jsp"></c:import>
</head>
<body>
	<c:import url="/WEB-INF/views/template/layout_header.jsp"></c:import>
	<div class = "container-fluid my-5">
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
	  <c:forEach items="${list}" var ="ar">
	  
	    <tr>
	      <th scope="row"><a href="./detail?productNum=${ar.productNum}">${ar.productNum}</a></th>
	      <td>${ar.productName}</td>
	      <td>${ar.productDetail}</td>
	      <td>${ar.productRate}</td>
	      <td>${ar.productDate}</td>
	    </tr>
	  </c:forEach>
	  </tbody>
	</table>
		<nav aria-label="Page navigation example" >
		  <ul class="pagination">
		    <li class="page-item"><a class="page-link" href="./list?page=${pager.start-1}">이전</a></li>
		    <c:forEach begin = "${pager.start}" end="${pager.end}" var ="i">
		    <li class="page-item"><a class="page-link" href="./list?page=${i}}">${i}</a></li>
		    </c:forEach>  
		    <li class="page-item ${pager.endCheck?'disabled':''}"><a class="page-link" href="./list?page=${pager.end+1}">다음</a></li>
		  </ul>
		</nav>
	<c:if test="${user.user_name eq 'sss' }">
	<a href ="./add" class ="btn btn-outline-primary">추가</a>
	</c:if>
	<c:if test="${user.user_name ne 'sss'}">
	</c:if>
</div>
	<c:import url="/WEB-INF/views/template/layout_footer.jsp"></c:import>
	
<c:import url="../template/boot_js.jsp"></c:import>
</body>
</html>