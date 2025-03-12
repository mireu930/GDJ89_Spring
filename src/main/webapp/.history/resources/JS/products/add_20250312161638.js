/**
 * 
 */
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