const check = document.getElementsByClassName("check");
const checkAll = document.getElementById("checkAll");
const cartDelete = document.getElementById("cart-delete");
const cartAdd = document.getElementById("cart-add");

checkAll.addEventListener("click",()=>{
  for(let c of check){
    c.checked= checkAll.checked;
  }
})

let number = [];

cartDelete.addEventListener("click",()=>{
  let url = new URL("cartDelete",window.location);
  for(let c of check){
    if(c.checked){
      let num = c.getAttribute("data-product-num");
      console.log(num);
      url.searchParams.append("productNum",num);
      // number.pop(num);
    }
    
    fetch(url)
    .then(result=>result.text())
    .then(result=>{
      alert('삭제되었습니다')

      window.location.reload();
      console.log(result);
    })
  }
})

cartAdd.addEventListener("click", ()=> {
  let params = new URLSearchParams();
  for(let c of check){
    if(c.checked){
      let num = c.getAttribute("data-product-num");
      // console.log(num);
      params.append("productNum",num);
    }

    let url = "../accounts/add?"+params.toString();
    console.log(url);

    fetch(url)
    .then(result=>result.text())
    .then(result=>{
      console.log(result);
    })
  }
})