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
	      <th scope="row"><a href="./detail">${ar.productNum}</a></th>
	      <td>${ar.productName}</td>
	      <td>${ar.productDetail}</td>
	      <td>@${ar.productRate}</td>
	      <td>@${ar.productDate}</td>
	    </tr>
	  </c:forEach>
	  </tbody>
	</table>
	
	<a href ="./add" class ="btn btn-outline-primary">추가</a>
</div>
	<c:import url="/WEB-INF/views/template/layout_footer.jsp"></c:import>
	
<c:import url="../template/boot_js.jsp"></c:import>
</body>
</html>