/**
 * 
 */
document.addEventListener('DOMContentLoaded',function(){

  var userNameInput = document.getElementById('validationServer02');
  userNameInput.addEventListener('input', function() {
      var feedback = document.getElementById('validationServerServer02Feedback');
    if(userNameInput.value.trim()!==''){
      feedback.style.display = 'none';
      userNameInput.classList.remove('is-invalid');
    }else {
      feedback.style.display='block';
      userNameInput.classList.add('is-invalid')
    }
  });
  
  var passwordInput = document.getElementById('validationServerUsername');
  passwordInput.addEventListener('input', function() {
      var feedback = document.getElementById('validationServerUsernameFeedback');
    if(passwordInput.value.trim()!==''){
      feedback.style.display = 'none';
      passwordInput.classList.remove('is-invalid');
    }else {
      feedback.style.display='block';
      passwordInput.classList.add('is-invalid')
    }
  });
});