<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<c:import url="/WEB-INF/views/template/boot_css.jsp"></c:import>
	<script src="/resources/JS/login.js">
		// document.addEventListener('DOMContentLoaded', function () {
			
			
		// 	var userNameInput = document.getElementById('validationServer02');
		// 	userNameInput.addEventListener('input', function () {
		// 		var feedback = document.getElementById('validationServerServer02Feedback');
		// 		if (userNameInput.value.trim() !== '') {
		// 			feedback.style.display = 'none';
		// 			userNameInput.classList.remove('is-invalid');
		// 		} else {
		// 			feedback.style.display = 'block';
		// 			userNameInput.classList.add('is-invalid');
		// 		}
		// 	});
		
		// 	var passwordInput = document.getElementById('validationServerUsername');
		// 	passwordInput.addEventListener('input', function () {
		// 		var feedback = document.getElementById('validationServerUsernameFeedback');
		// 		if (passwordInput.value.trim() !== '') {
		// 			feedback.style.display = 'none';
		// 			passwordInput.classList.remove('is-invalid');
		// 		} else {
		// 			feedback.style.display = 'block';
		// 			passwordInput.classList.add('is-invalid');
		// 		}
		// 	});
			
		// });
		
	</script>
</head>
<body>
	<c:import url="/WEB-INF/views/template/layout_header.jsp"></c:import>
	<div class = "container-fluid my-5">
		<div class = "row col-md-8 offset-md-2">
			<form class="row g-3" action = "./login" method = "post">
			  <div class="col-md-4">
			    <label for="user_name" class="form-label">아이디</label>
			    <div class="input-group has-validation">
			      <input type="text" name="user_name"  class="form-control is-invalid" id="validationServer02" aria-describedby="inputGroupPrepend3 validationServerServer02Feedback" required>
			      <div id="validationServerServer02Feedback" class="invalid-feedback">
			        아이디를 입력하세요.
			      </div>
			    </div>
			  </div>
			  <div class="col-md-4">
			    <label for="password" class="form-label">비밀번호</label>
			    <div class="input-group has-validation">
			      <input type="password" name="password" class="form-control is-invalid" id="validationServerUsername" aria-describedby="inputGroupPrepend3 validationServerUsernameFeedback" required>
			      <div id="validationServerUsernameFeedback" class="invalid-feedback">
			        비밀번호를 입력하세요.
			      </div>
			    </div>
			  </div>
			  <div class="col-12">
			    <button class="btn btn-primary" type="submit">로그인</button>
			  </div>
			</form>
		</div>
	</div>
	<c:import url="/WEB-INF/views/template/layout_footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/template/boot_js.jsp"></c:import>
</body>
</html>