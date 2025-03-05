/**
 * 
 */
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

			userNameInput.addEventListener('change',function() {
				console.log(userNameInput.value);

				fetch("./users/check").then(result=>{
					return result.text
				})
			})
		
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
			
						var checkbox = document.getElementById('invalidCheck3');
						var label = document.querySelector('label[for="invalidCheck3"]');
						var feedback = document.getElementById('invalidCheck3Feedback');

						checkbox.addEventListener('change', function () {
							if (checkbox.checked) {
								feedback.style.display = 'none';
								label.style.color = 'blue';
							} else {
								feedback.style.display = 'block';
								label.style.color = '';
								checkbox.style.borderColor = ''; 
							}
				});
		});