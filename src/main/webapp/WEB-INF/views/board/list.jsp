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
	<c:if test="${kind eq 'qna'}">
		 <c:import url="/WEB-INF/views/template/layout_header.jsp"></c:import>
	</c:if> 
	<c:if test="${kind eq 'notice'}"> 
		<c:import url="/WEB-INF/views/template/layout_header2.jsp"></c:import>
	</c:if>
	<div class = "container-fluid my-5">
		<form class="row row-cols-lg-auto g-3 align-items-center" action="./list" method ="get" id="list_form">
		<input type="hidden" name="page" id="pageNum">
		  <div class="col-12">
		    <label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
		    <select class="form-select" name="kind" id="inlineFormSelectPref">
		      <option value="k1">제목</option>
		      <option value="k2">작성자</option>
		      <option value="k3">제목+작성자</option>
		    </select>
		  </div>
		  <div class="col-12">
		    <label class="visually-hidden" for="inlineFormInputGroupUsername"></label>
		      <input type="text" name="search" value="${pager.search}" class="form-control" id="inlineFormInputGroupUsername" placeholder="검색어를 입력하세요">
		  </div>
		
		  <div class="col-12">
		    <button type="submit" class="btn btn-primary">검색</button>
		  </div>
		</form>
	
	<table class="table table-striped table-hover">
 		<thead>
	    <tr>
	      <th scope="col">번호</th>
	      <th scope="col">제목</th>
	      <th scope="col">작성자</th>
	      <th scope="col">등록날짜</th>
	      <th scope="col">조회수</th>
	    </tr>
	  </thead>
	  <tbody>
	  <c:forEach items="${list}" var ="ar">
	  
	    <tr>
	      <th scope="row"><a href="./detail?boardNum=${ar.boardNum}">${ar.boardNum}</a></th>
	      <td>
	      <c:catch>
	      <c:forEach begin ="1" end="${ar.boardDepth}" varStatus="ar2">
	      -
	      <c:if test="${ar2.last}">
	      Re
	      </c:if>
	      </c:forEach> 
	      </c:catch>
	      ${ar.boardTitle}
	      </td>
	      <td>${ar.user_name}</td>
	      <td>${ar.boardDate}</td>
	      <td>${ar.boardHit}</td>
	    </tr>
	  </c:forEach>
	  </tbody>
	</table>
	<nav aria-label="Page navigation example">
  		<ul class="pagination">
  			
		    <li class="page-item"><button class="page-link pages" data-page-num="${pager.start-1}">Previous</button></li>
  			<c:forEach begin="${pager.start}" end="${pager.end}" var="i">
		    	<li class="page-item"><button class="page-link pages" data-page-num="${i}">${i}</button></li>
  			</c:forEach>
		   <li class="page-item ${pager.endCheck?'disabled':''}"><button class="page-link pages" data-page-num="${pager.end+1}">Next</button></li>
	  	</ul>
	</nav>																			
		<a href ="./add" class ="btn btn-outline-primary">추가</a>	

</div>
	<c:import url="/WEB-INF/views/template/layout_footer.jsp"></c:import>
	<script src="/resources/JS/list.js"></script>
<c:import url="../template/boot_js.jsp"></c:import>
</body>
</html>