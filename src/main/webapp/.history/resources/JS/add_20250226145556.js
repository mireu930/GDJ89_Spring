const productName = document.getElementById("validationServer02");
const productDetail = document.getElementById("validationServerUsername");
const productRate = document.getElementById("validationServer03");
const productDate = document.getElementById("validationServer04");
const check = document.getElementById("invalidCheck3");

document.addEventListener("DOMContentLoaded", function(){
  productName.addEventListener("input", function(){
    let productNameFeedback = document.getElementById("validationServerServer02Feedback");
      if(productName.value.trim()!==''){
        productNameFeedback.style.display='none';
        productName.classList.remove('is-invalid');
      }else {
        productNameFeedback.style.display='block';
        productName.classList.add('is-invalid');
      }
  })

  productDetail.addEventListener("input", function(){
    let productDetailFeedback = document.getElementById("validationServerUsernameFeedback");
      if(productDetail.value.trim()!==''){
        productDetailFeedback.style.display='none';
        productDetail.classList.remove('is-invalid');
      }else {
        productDetailFeedback.style.display='block';
        productDetail.classList.add('is-invalid');
      }
  })

  productRate.addEventListener("input", function(){
    let productRateFeedback = document.getElementById("validationServer03Feedback");
      if(productRate.value.trim()!==''){
        productRateFeedback.style.display='none';
        productRate.classList.remove('is-invalid');
      }else {
        productRateFeedback.style.display='block';
        productRate.classList.add('is-invalid');
      }
  })

  productDate.addEventListener("input", function(){
    let productDateFeedback = document.getElementById("validationServer04Feedback");
      if(productDate.value.trim()!==''){
        productDateFeedback.style.display='none';
        productDate.classList.remove('is-invalid');
      }else {
        productDateFeedback.style.display='block';
        productDate.classList.add('is-invalid');
      }
  })

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

})