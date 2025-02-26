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

			  <div class="col-md-4">
			    <label for="user_name" class="form-label">아이디</label>
			    <div class="input-group has-validation">
			      <input type="text" name="user_name" value="${user.user_name}" id="validationServer02"  readonly>

			    </div>
			  </div> 
			  <div class="col-md-4">
			    <label for="password" class="form-label">비밀번호</label>
			    <div class="input-group has-validation">
			      <input type="password" name="password" value="${user.password}" id="validationServerUsername" readonly>

			    </div>
			  </div>
			  <div class="col-md-6">
			    <label for="name" class="form-label">이름</label>
			    <input type="text" name = "name" value="${user.name}" id="validationServer03"  readonly>

			  </div>
			  <div class="col-md-3">
			    <label for="phone" class="form-label">폰번호</label>
			    <input type="text" name ="phone" value="${user.phone}"  id="validationServer04"  readonly>

			  </div>
			  <div class="col-md-3">
			    <label for="email" class="form-label">이메일</label>
			    <input type="text" name ="email" value="${user.email}" id="validationServer05" readonly>
			  </div>
			  <div>
				<form action="/test" id="frm">
					<input type="hidden" name="productNum" value="${user.user_name}">
					<button type="button" id="btn1" class="btn btn-outline-success">수정</button>
					<button type="button" id="btn2" class="btn btn-outline-danger">삭제</button>
				</form>
			</div>	
			  
			  
		</div>
	</div>
	<script src="/resources/JS/detail.js"></script>
	<c:import url="/WEB-INF/views/template/layout_footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/template/boot_js.jsp"></c:import>
</body>
</html>