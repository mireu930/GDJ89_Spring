<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<c:import url="/WEB-INF/views/template/boot_css.jsp"></c:import>
	<!-- <script>
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
			
						// 체크박스 상태에 따라 문구와 체크박스 스타일을 변경
						var checkbox = document.getElementById('invalidCheck3');
						var label = document.querySelector('label[for="invalidCheck3"]');
						var feedback = document.getElementById('invalidCheck3Feedback');

						checkbox.addEventListener('change', function () {
							if (checkbox.checked) {
								feedback.style.display = 'none';  // "You must agree..." 메시지 숨김
								label.style.color = 'blue';  // 체크박스 라벨 색상 파란색으로 변경
							} else {
								feedback.style.display = 'block';  // 메시지 다시 보이게
								label.style.color = '';  // 기본 색상으로 복원
								checkbox.style.borderColor = '';  // 기본 테두리 색상으로 복원
							}
				});
		});
	</script> -->
</head>
<body>
	<c:import url="/WEB-INF/views/template/layout_header.jsp"></c:import>
	<div class = "container-fluid my-5">
		<div class = "row col-md-8 offset-md-2">
			<form class="row g-3" action = "./add" method = "post">
			  <div class="col-md-4">
			    <label for="productName" class="form-label">상품이름</label>
			    <div class="input-group has-validation">
			      <input type="text" name="productName"  class="form-control is-invalid" id="validationServer02" aria-describedby="inputGroupPrepend3 validationServerUsernameFeedback" required>
			      <div id="validationServerServer02Feedback" class="invalid-feedback">
			        상품이름을 입력하세요.
			      </div>
			    </div>
			  </div>
			  <div class="col-md-4">
			    <label for="productDetail" class="form-label">상품상세설명</label>
			    <div class="input-group has-validation">
			      <!-- <span class="input-group-text" id="inputGroupPrepend3">@</span> -->
			      <input type="text" name="productDetail" class="form-control is-invalid" id="validationServerUsername" aria-describedby="inputGroupPrepend3 validationServerUsernameFeedback" required>
			      <div id="validationServerUsernameFeedback" class="invalid-feedback">
			        상품상세설명을 입력하세요.
			      </div>
			    </div>
			  </div>
			  <div class="col-md-6">
			    <label for="productRate" class="form-label">이자율</label>
			    <input type="text" name = "productRate" class="form-control is-invalid" id="validationServer03" aria-describedby="validationServer03Feedback" required>
			    <div id="validationServer03Feedback" class="invalid-feedback">
			      이자율을 입력하세요.
			    </div>
			  </div>
			  <div class="col-md-3">
			    <label for="productDate" class="form-label">상품기간</label>
			    <input type="date" name ="productDate" class="form-control is-invalid" id="validationServer04" aria-describedby="validationServer03Feedback" required>
			    <div id="validationServer04Feedback" class="invalid-feedback">
			      상품기간을 입력하세요.
			    </div>
			  </div>
			  <div class="col-12">
			    <div class="form-check">
			      <input class="form-check-input is-invalid" type="checkbox" value="" id="invalidCheck3" aria-describedby="invalidCheck3Feedback" required>
			      <label class="form-check-label" for="invalidCheck3">
			        상품등록에 동의합니다.
			      </label>
			      <div id="invalidCheck3Feedback" class="invalid-feedback">
			        상품등록하기전에 동의를 눌러주세요.
			      </div>
			    </div>
			  </div>
			  <div class="col-12">
			    <button class="btn btn-primary" type="submit">등록</button>
			  </div>
			</form>
		</div>
	</div>
	<c:import url="/WEB-INF/views/template/layout_footer.jsp"></c:import>
	<script src="/resources/JS/add.js"></script>
	<c:import url="/WEB-INF/views/template/boot_js.jsp"></c:import>
</body>
</html>