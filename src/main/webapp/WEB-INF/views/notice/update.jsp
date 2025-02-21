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
			
			
			var productNameInput = document.getElementById('validationServer02');
			productNameInput.addEventListener('input', function () {
				var feedback = document.getElementById('validationServerServer02Feedback');
				if (productNameInput.value.trim() !== '') {
					feedback.style.display = 'none';
					productNameInput.classList.remove('is-invalid');
				} else {
					feedback.style.display = 'block';
					productNameInput.classList.add('is-invalid');
				}
			});
			// 상품상세설명 입력 필드에 대한 이벤트 리스너
			var productDetailInput = document.getElementById('validationServerUsername');
			productDetailInput.addEventListener('input', function () {
				var feedback = document.getElementById('validationServerUsernameFeedback');
				if (productDetailInput.value.trim() !== '') {
					feedback.style.display = 'none';
					productDetailInput.classList.remove('is-invalid');
				} else {
					feedback.style.display = 'block';
					productDetailInput.classList.add('is-invalid');
				}
			});
			
			// 이자율 입력 필드에 대한 이벤트 리스너
			var interestRateInput = document.getElementById('validationServer03');
			interestRateInput.addEventListener('input', function () {
				var feedback = document.getElementById('validationServer03Feedback');
				if (interestRateInput.value.trim() !== '') {
					feedback.style.display = 'none';
					interestRateInput.classList.remove('is-invalid');
				} else {
					feedback.style.display = 'block';
					interestRateInput.classList.add('is-invalid');
				}
			});
			
			// 상품기간 입력 필드에 대한 이벤트 리스너
			var productPeriodInput = document.getElementById('validationServer04');
			productPeriodInput.addEventListener('input', function () {
				var feedback = document.getElementById('validationServer04Feedback');
				if (productPeriodInput.value.trim() !== '') {
					feedback.style.display = 'none';
					productPeriodInput.classList.remove('is-invalid');
				} else {
					feedback.style.display = 'block';
					productPeriodInput.classList.add('is-invalid');
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
			    <div class="input-group has-validation">
			      <!-- <span class="input-group-text" id="inputGroupPrepend3">@</span> -->
			      <input type="hidden" name=boardNum value="${notice.boardNum}"  class="form-control is-invalid" id="validationServer01" aria-describedby="inputGroupPrepend3 validationServerUsernameFeedback" required>
			    </div>
			    
			    <div class="input-group has-validation">
			      <label for="boardTitle" class="form-label">제목</label>
			      <input type="text" name="boardTitle" value="${notice.boardTitle}"  class="form-control is-invalid" id="validationServer02" aria-describedby="inputGroupPrepend3 validationServerUsernameFeedback" required>
			      <div id="validationServerServer02Feedback" class="invalid-feedback">
			        Please choose a detail.
			      </div>
			    </div>
			  </div>
			  <div class="col-md-4">
			    <label for="boardContent" class="form-label">내용</label>
			    <div class="input-group has-validation">
			      <!-- <span class="input-group-text" id="inputGroupPrepend3">@</span> -->
			      <input type="text" name="boardContent" value="${notice.boardContent}" class="form-control is-invalid" id="validationServerUsername" aria-describedby="inputGroupPrepend3 validationServerUsernameFeedback" required>
			      <div id="validationServerUsernameFeedback" class="invalid-feedback">
			        Please choose a detail.
			      </div>
			    </div>
			  </div>
			  <div class="col-12">
			    <button class="btn btn-primary" type="submit">수정</button>
			    <a href="./list" class ="btn btn-outline-danger">취소</a>	
			  </div>
			</form>
		</div>
	</div>
	<c:import url="/WEB-INF/views/template/layout_footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/template/boot_js.jsp"></c:import>
</body>
</html>