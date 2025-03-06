const check = document.getElementsByClassName("check");
const checkAll = document.getElementById("checkAll");
const cartDelete = document.getElementById("cart-delete");

checkAll.addEventListener("click",()=>{
  for(let c of check){
    c.checked= checkAll.checked;
  }
})

let nums = [];

cartDelete.addEventListener("click",()=>{
  let url = new URL("cartDelete",window.location);
  for(let c of check){
    if(c.checked){
      let num = c.getAttribute("data-product-num");
      console.log(num);
      url.searchParams.append("productNum",num);
      nums.pop(num);
    }
    
    fetch(url)
    .then(result=>result.text())
    .then(result=>{
      alert('삭제되었습니다')

      //window.location.reload();
      console.log(result);
    })



  }
})