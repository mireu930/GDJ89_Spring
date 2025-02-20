<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<c:import url="/WEB-INF/views/template/boot_css.jsp"></c:import>
	<script>
		document.addEventListener('DOMContentLoaded', function () {
			
			
			var userNameInput = document.getElementById('validationServer02');
			userNameInput.addEventListener('input', function () {
				var feedback = document.getElementById('validationServerServer02Feedback');
				if (userNameInput.value.trim() !== '') {
					feedback.style.display = 'none';
					userNameInput.classList.remove('is-invalid');
				} else {
					feedback.style.display = 'block';
					userNameInput.classList.add('is-invalid');
				}
			});
		
			var passwordInput = document.getElementById('validationServerUsername');
			passwordInput.addEventListener('input', function () {
				var feedback = document.getElementById('validationServerUsernameFeedback');
				if (passwordInput.value.trim() !== '') {
					feedback.style.display = 'none';
					passwordInput.classList.remove('is-invalid');
				} else {
					feedback.style.display = 'block';
					passwordInput.classList.add('is-invalid');
				}
			});
			
		
			var nameInput = document.getElementById('validationServer03');
			nameInput.addEventListener('input', function () {
				var feedback = document.getElementById('validationServer03Feedback');
				if (nameInput.value.trim() !== '') {
					feedback.style.display = 'none';
					nameInput.classList.remove('is-invalid');
				} else {
					feedback.style.display = 'block';
					nameInput.classList.add('is-invalid');
				}
			});
			
	
			var emailInput = document.getElementById('validationServer04');
			emailInput.addEventListener('input', function () {
				var feedback = document.getElementById('validationServer04Feedback');
				if (emailInput.value.trim() !== '') {
					feedback.style.display = 'none';
					emailInput.classList.remove('is-invalid');
				} else {
					feedback.style.display = 'block';
					emailInput.classList.add('is-invalid');
				}
			});
			
			var phoneInput = document.getElementById('validationServer05');
			phoneInput.addEventListener('input', function () {
				var feedback = document.getElementById('validationServer05Feedback');
				if (phoneInput.value.trim() !== '') {
					feedback.style.display = 'none';
					phoneInput.classList.remove('is-invalid');
				} else {
					feedback.style.display = 'block';
					phoneInput.classList.add('is-invalid');
				}
			});
		});
	</script>
</head>
<body>
	<c:import url="/WEB-INF/views/template/layout_header.jsp"></c:import>
	<div class = "container-fluid my-5">
		<div class = "row col-md-8 offset-md-2">
			<form class="row g-3" action = "./update" method = "post">
			  <div class="col-md-4">
			    <label for="user_name" class="form-label">아이디</label>
			    <div class="input-group has-validation">
			      <input type="text" name="user_name" value="${user.user_name}"  class="form-control is-invalid" id="validationServer02" aria-describedby="inputGroupPrepend3 validationServerServer02Feedback" required>
			      <div id="validationServerServer02Feedback" class="invalid-feedback">
			        아이디를 입력하세요.
			      </div>
			    </div>
			  </div> 
			  <div class="col-md-4">
			    <label for="password" class="form-label">비밀번호</label>
			    <div class="input-group has-validation">
			      <input type="password" name="password" value="${user.password}" class="form-control is-invalid" id="validationServerUsername" aria-describedby="inputGroupPrepend3 validationServerUsernameFeedback" required>
			      <div id="validationServerUsernameFeedback" class="invalid-feedback">
			        비밀번호를 입력하세요.
			      </div>
			    </div>
			  </div>
			  <div class="col-md-6">
			    <label for="name" class="form-label">이름</label>
			    <input type="text" name = "name" value="${user.name}" class="form-control is-invalid" id="validationServer03" aria-describedby="validationServer03Feedback" required>
			    <div id="validationServer03Feedback" class="invalid-feedback">
			     이름을 입력하세요.
			    </div>
			  </div>
			  <div class="col-md-3">
			    <label for="phone" class="form-label">폰번호</label>
			    <input type="text" name ="phone" value="${user.phone}" class="form-control is-invalid" id="validationServer04" aria-describedby="validationServer04Feedback" required>
			    <div id="validationServer04Feedback" class="invalid-feedback">
			      폰번호를 입력하세요.
			    </div>
			  </div>
			  <div class="col-md-3">
			    <label for="email" class="form-label">이메일</label>
			    <input type="text" name ="email" value="${user.email}" class="form-control is-invalid" id="validationServer05" aria-describedby="validationServer05Feedback" required>
			    <div id="validationServer05Feedback" class="invalid-feedback">
			      이메일을 입력하세요.
			    </div>
			  </div>
			  <div class="col-12">
			  </div>
			  <div class="col-12">
			    <button class="btn btn-primary" type="submit">수정</button>
			  </div>
			</form>
		</div>
	</div>
	<c:import url="/WEB-INF/views/template/layout_footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/template/boot_js.jsp"></c:import>
</body>
</html>