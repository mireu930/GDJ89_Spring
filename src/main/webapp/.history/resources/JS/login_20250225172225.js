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

  }
})