const productName = document.getElementById("validationServer02");
const productDetail = document.getElementById("validationServerUsername");
const productRate = document.getElementById("validationServer03");
const productDate = document.getElementById("validationServer04");
const check = document.getElementById("invalidCheck3");

document.addEventListener("DOMContentLoaded", function(){
  productName.addEventListener("input", function(){
    let productNameFeedback = document.getElementById("validationServerServer02Feedback");
      if(productNameFeedback.value.trim()!==''){
        productNameFeedback.style.display='none'
        productName.classList.remove('is-invalid')
      }
  })

})