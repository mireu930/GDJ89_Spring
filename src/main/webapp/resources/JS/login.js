/**
 * 
 */
document.addEventListener("DOMContentLoaded",function(){

  var userNameInput = document.getElementById("validationServer02");
  var passwordInput = document.getElementById("validationServerUsername");
  
  userNameInput.addEventListener("input", function() {
    if(userNameInput.value.trim()!==''){
      var feedback = document.getElementById("validationServerServer02Feedback");
      feedback.style.display = 'none';
      userNameInput.classList.remove('is-invalid');
    }else {
      feedback.style.display='block';
      userNameInput.classList.add('is-invalid')
    }
  })
  
  passwordInput.addEventListener("input", function() {
    if(passwordInput.value.trim()!==''){
      var feedback = document.getElementById("validationServerUsernameFeedback");
      feedback.style.display = 'none';
      passwordInput.classList.remove('is-invalid');
    }else {
      feedback.style.display='block';
      passwordInput.classList.add('is-invalid')
    }
  })
})