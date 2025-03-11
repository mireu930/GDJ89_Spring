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

document.addEventListener('DOMContentLoaded', function() {
  const commentId = document.getElementById('commentId');
  const productComment = document.getElementById('productComment');

  if (commentId) {
    commentId.addEventListener("click", function() {
      console.log("click");
      let num = commentId.getAttribute("data-comment-boardNum");
      let contents = productComment.value;

      // 입력값 유효성 검사
      if (!contents.trim()) {
        alert("댓글 내용을 입력해주세요.");
        return;
      }

      // FormData로 요청 보내기
      let p = makeForm(num, contents);

      fetch("./addComments", {
        method: "POST",
        headers: {
          "Content-type": "application/x-www-form-urlencoded"
        },
        body: p
      })
      .then(res => res.text()) // 서버 응답이 텍스트로 올 경우
      .then(res => {
        console.log(res);
        alert('댓글이 달렸습니다.');
        // 댓글 내용 입력 필드 초기화
        productComment.value = '';
      })
      .catch(error => {
        console.error("Error:", error);
        alert("댓글 등록에 실패했습니다.");
      });
    });
  } else {
    console.log("commentId 버튼을 찾을 수 없습니다.");
  }
});

function makeForm(pn, contents) {
  let f = new FormData();
  f.append("productNum", num);
  f.append("boardContents", contents);

  return f;
}

function makeParam(num, contents) {
  let p = new URLSearchParams();
  p.append("productNum", num);
  p.append("boardContents", contents);

  return p;
}

getList();

function getList() {
  fetch("./listComments", {
    method: 'GET',
    headers: {
      "Content-type": "application/x-www-form-urlencoded"
    }, 
    body: "productNum="+num
  })
  .then(res => res.text)
  .then(res => {

  })
}