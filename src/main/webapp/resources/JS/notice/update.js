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