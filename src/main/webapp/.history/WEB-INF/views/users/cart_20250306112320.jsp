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
		<form class="row row-cols-lg-auto g-3 align-items-center" action="./cart" method ="get">
		  <div class="col-12">
		    <label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
		    <select class="form-select" name="kind" id="inlineFormSelectPref">
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
		<div style="display:flex; gap:10px; margin: 10px 0 10px 0">
		<c:forEach items="${cart}" var ="ar">
		<div class="card" style="width: 18rem;">
		
		<a href="../products/detail?productNum=${ar.productNum}">
  			<img src="/resources/images/products/${not empty ar.productFileDTO?ar.productFileDTO.fileName:'noImage.jpg'} " class="card-img-top rounded" width="200px" height="200px" alt="">
		</a>
	  			<div class="card-body">
	    		<p class="card-text">
	    		#${ar.productNum} ${ar.productName}<br>
	    		${ar.productRate} / ${ar.productDate}
	    		</p>
	  			</div>
			</div>
		</c:forEach>
	</div>
		<nav aria-label="Page navigation example" >
		  <ul class="pagination">
		    <li class="page-item"><a class="page-link" href="./list?page=${pager.start-1}&kind=${param.kind}&search=${param.search}">이전</a></li>
		    <c:forEach begin = "${pager.start}" end="${pager.end}" var ="i">
		    <li class="page-item"><a class="page-link" href="./list?page=${i}&kind=${param.kind}&search=${param.search}">${i}</a></li>
		    </c:forEach>  
		    <li class="page-item ${pager.endCheck?'disabled':''}"><a class="page-link" href="./list?page=${pager.end+1}&kind=${param.kind}&search=${param.search}">다음</a></li>
		  </ul>
		</nav> 
</div>
	<c:import url="/WEB-INF/views/template/layout_footer.jsp"></c:import>
	
<c:import url="../template/boot_js.jsp"></c:import>
</body>
</html>