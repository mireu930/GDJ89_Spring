const check = document.getElementsByClassName("check");
const checkAll = document.getElementById("checkAll");
const cartDelete = document.getElementById("cart-delete");

checkAll.addEventListener("click",()=>{
  for(let c of check){
    c.checked= checkAll.checked;
  }
})

cartDelete.addEventListener("click",()=>{
  for(let c of check){
    if(c.checked){
      let num = c.getAttribute("data-product-num");
      console.log(num);
    }
    // fetch(`./cartDelete?productNum=${num}`)
    // .then(result=>result.text())
    // .then(result=>{
    //   console.log(result);
    // })

    let url = new URL("./user/test");
    console.log(url);
    console.log(url.href);
    console.log(typeof(url));

  }
})