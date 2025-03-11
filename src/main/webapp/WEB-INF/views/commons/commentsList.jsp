<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table>
    <thead>
        <tr>
            <th>작성자</th>
            <th>내용</th>
            <th>작성일</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${list}" var="c">
            <tr>
                <th>${c.user_name}</th>
                <th>${c.boardContents}</th>
                <th>${c.boardDate}</th>
            </tr>
        </c:forEach>
    </tbody>

</table>
<nav aria-label="Page navigation example" >
	<ul class="pagination">
	<li class="page-item"><a class="page-link" href="./list?page=${pager.start-1}&kind=${param.kind}&search=${param.search}">이전</a></li>
		<c:forEach begin = "${pager.start}" end="${pager.end}" var ="i">
		<li class="page-item"><a class="page-link" href="./list?page=${i}&kind=${param.kind}&search=${param.search}">${i}</a></li>
		</c:forEach>  
	<li class="page-item ${pager.endCheck?'disabled':''}"><a class="page-link" href="./list?page=${pager.end+1}&kind=${param.kind}&search=${param.search}">다음</a></li>
</ul>
</nav>