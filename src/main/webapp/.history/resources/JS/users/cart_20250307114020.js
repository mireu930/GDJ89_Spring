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
  }
    
    fetch(url)
    .then(result=>result.text())
    .then(result=>{
      alert('삭제되었습니다')

      window.location.reload();
      console.log(result);
    })
})

cartAdd.addEventListener("click", ()=> {
  let params = new URLSearchParams();
  for(let c of check){
    if(c.checked){
      let num = c.getAttribute("data-product-num");
      // console.log(num);
      params.append("productNum",num);
    }
  }

    //let url = "../accounts/add2?"+params.toString();
    //console.log(url);

    //enctype 아무런설정없으면 multipart/form-data
    fetch("../accounts/add2",{
      method:"POST",
      headers: {
        'Content-type': 'application/x-www-form-urlencoded; charset=UTF-8'
      }
    }) //promise 응답받는 객체
    .then(result=>result.text())
    .then(result=>{
      if(result.trim() > '0'){
        alert('상품이 추가되었습니다')
        
        window.location.reload();
        const con = confirm("계좌목록으로 이동하시겠습니까?");
      }

		
		if(con) {
			window.location.href ="../accounts/list";
			}
    })
    .catch(e=>{
      alert('관리자에게 문의하세요')
    })
})