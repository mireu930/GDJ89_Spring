const check = document.getElementsByClassName("check");
const checkAll = document.getElementById("checkAll");
const cartDelete = document.getElementById("cart-delete");

checkAll.addEventListener("click",()=>{
  for(let c of check){
    c.checked= checkAll.checked;
  }
})

cartDelete.addEventListener("click",()=>{
  let url = new URL("cartDelete",window.location);
  for(let c of check){
    if(c.checked){
      let num = c.getAttribute("data-product-num");
      console.log(num);
    }
    let param = new URLSearchParams("");
    url.search="productNum=1"
    fetch(url)
    .then(result=>result.text())
    .then(result=>{
      console.log(result);
    })



  }
})