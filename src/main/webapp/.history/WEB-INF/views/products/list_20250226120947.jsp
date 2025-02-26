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
		<form class="row row-cols-lg-auto g-3 align-items-center" action="./list" method ="get" id="list_form">
		<input type="hidden" name="page">
		  <div class="col-12">
		    <label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
		    <select class="form-select" value="${pager.search}" name="kind" id="inlineFormSelectPref">
		      <option value="k1">제목</option>
		      <option value="k2">내용</option>
		      <option value="k3">제목+내용</option>
		    </select>
		  </div>
		  <div class="col-12">
		    <label class="visually-hidden" for="inlineFormInputGroupUsername"></label>
		      <input type="text" name="search" class="form-control" id="inlineFormInputGroupUsername" placeholder="검색어를 입력하세요">
		  </div>
		
		  <div class="col-12">
		    <button type="submit" class="btn btn-primary">검색</button>
		  </div>
		</form>
	
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
		    <li class="page-item"><button class="page-link pages" href="./list?page=${pager.start-1}&kind=${param.kind}&search=${param.search}">이전</button></li>
		    <c:forEach begin = "${pager.start}" end="${pager.end}" var ="i">
		    <li class="page-item"><button class="page-link pages" href="./list?page=${i}&kind=${param.kind}&search=${param.search}">${i}</button></li>
		    </c:forEach>  
		    <li class="page-item ${pager.endCheck?'disabled':''}"><button class="page-link pages" href="./list?page=${pager.end+1}&kind=${param.kind}&search=${param.search}">다음</button></li>
		  </ul>
		</nav>
	<c:if test="${user.user_name eq 'sss' }">
	<a href ="./add" class ="btn btn-outline-primary">추가</a>
	</c:if>
	<c:if test="${user.user_name ne 'sss'}">
	</c:if>
</div>
	<c:import url="/WEB-INF/views/template/layout_footer.jsp"></c:import>
	<script src="/resources/JS/list.js"></script>
<c:import url="../template/boot_js.jsp"></c:import>
</body>
</html>