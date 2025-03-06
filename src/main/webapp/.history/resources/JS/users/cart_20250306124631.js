const check = document.getElementsByClassName("check");
const checkAll = document.getElementById("checkAll");
const cartDelete = document.getElementById("cart-delete");

checkAll.addEventListener("click",()=>{
  for(let c of check){
    c.checked= checkAll.checked;
  }
})

cartDelete.addEventListener("click",()=>{
  for( let c of check){
    c.checked=cartDelete.getAttribute("data-product-num")
  }
})