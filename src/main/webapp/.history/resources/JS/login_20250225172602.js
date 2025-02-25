/**
 * 
 */
const userNameInput = document.getElementById("validationServer02");
const passwordInput = document.getElementById("validationServerUsername");

userNameInput.addEventListener("input", function() {
  if(userNameInput.value.trim()!=''){
    let feedback = document.getElementById("validationServerServer02Feedback");
    feedback.style.display = 'none';
    userNameInput.classList.remove('is-inValid');
  }else {
    feedback.style.display='block';
    userNameInput.classList.add('is-inValid')
  }
})

passwordInput.addEventListener("input", function() {
  if(passwordInput.value.trim()!=''){
    let feedback = document.getElementById("validationServerUsernameFeedback");
    feedback.style.display = 'none';
    passwordInput.classList.remove('is-inValid');
  }else {
    feedback.style.display='block';
    passwordInput.classList.add('is-inValid')
  }
})