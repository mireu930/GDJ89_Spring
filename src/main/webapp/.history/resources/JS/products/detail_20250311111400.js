const frm = document.getElementById("frm");
const btn1 = document.getElementById("btn1");
const btn2 = document.getElementById("btn2");
const addCart = document.getElementById("addCart");

addCart.addEventListener("click", ()=>{
    let num = addCart.getAttribute("data-product-num")
    let s = `hello ${num}`

    fetch(`../users/addCart?productNum=${num}`)
    .then(res => res.text())
    .then(res => {
		alert(res);
		if(res.includes("로그인")) {
			window.location.href ="../users/login"
		}else {
			const con = confirm("장바구니로 이동하시겠습니까?");
		
		if(con) {
			window.location.href ="../users/cart";
			}
		}
    })
    .catch(error => console.error("에러발생",error));
});

btn1.addEventListener("click", function(){
  console.log(frm.method);
  console.log(frm.getAttribute("method"));
  console.log("수정")
  frm.action ="./update"
  console.log(frm.getAttribute("action"));
  frm.submit();
})

btn2.addEventListener("click", function(){
  console.log("삭제")
  console.log(frm.getAttribute("action"));
  const conf = confirm("정말삭제하시겠습니까?");
  if(conf){
  	frm.action="./delete"
  	frm.method="POST";
    frm.submit();
  }
})

const commentId = document.getElementById("commentId");
const productComment = document.getElementById("productComment");

commentId.addEventListener("click", ()=> {
  console.log("click");
  let num = commentId.getAttribute("data-comment-boardNum");

  fetch(`./products/addComments?productNum=${num}`)
  .then(res => res.text())
  .then(res => {
    alert('댓글이 달렸습니다.')
  })
  
})