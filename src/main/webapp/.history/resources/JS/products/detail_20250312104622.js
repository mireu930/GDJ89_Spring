const frm = document.getElementById("frm");
const btn1 = document.getElementById("btn1");
const btn2 = document.getElementById("btn2");
const addCart = document.getElementById("addCart");
const addComments = document.getElementById("addComments");
const commentsContents = document.getElementById("commentsContents");
const commentsListResult = document.getElementById("commentsListResult");
const pages = document.getElementsByClassName("pages");
const modal_change = document.getElementById("modal-change");


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
});

addComments.addEventListener("click", async () => {
  console.log('click');
  console.log(commentsContents.value);
  console.log(addCart.getAttribute("data-product-num"));
  
  await add();
  await getList(1);

});

function makeForm(pn, contents){
  let f = new FormData();
  f.append("productNum", pn);
  f.append("boardContents", contents)

  return f;
}

function makeParam(pn, contents){

  let p = new URLSearchParams();
  p.append("productNum", pn);
  p.append("boardContents", contents)

  return p;
}

getList(1);


 function getList(page){
  let pn = addCart.getAttribute("data-product-num");
  fetch(`listComments?productNum=${pn}&page=${page}`)
  .then(r => r.text())
  .then(r => {
      commentsListResult.innerHTML=r;
  })
  .catch(e=> console.log(e))
  
}

async function add(){
  let pn = addCart.getAttribute("data-product-num");

  //let p = makeParam(pn, commentsContents.value);
  let p = makeForm(pn, commentsContents.value)

 

  fetch('./addComments', {
      method:'POST',
      body:p
  })
  .then(r=>r.text())
  .then(r=>{
      //getList()
      if(r.trim()*1>0){

      }else {

      }

      commentsContents.value="";

  })
  .catch(e =>{
      alert('에러 발생')
  })
}

commentsListResult.addEventListener('click', (e)=>{
  if(e.target.classList.contains('pages')){
      let p = e.target.getAttribute("data-page-num");
      getList(p)
  }
})

commentsListResult.addEventListener("click", async(e)=> {
  if (e.target.classList.contains('deleteComments')) {
    if(!confirm("정말삭제하시겠습니까?")){
      return;
    }

    let num = e.target.getAttribute("data-board-num");
    
    if(!num){
      alert('댓글번호가 없습니다.')
    }
    
    let params = new URLSearchParams();
    params.append("boardNum",num)
    await fetch("./deleteComments", {
      method: 'POST',
      headers : {'Content-type': 'application/x-www-form-urlencoded;charset=utf-8'},
      body:params.toString()
    })
    .then(result=>result.text())
    .then(result=>{
      console.log("서버응답"+result);
      if(result.trim()>'0'){

        alert('삭제되었습니다.')
      } else {
        alert('삭제실패')
      }
    })
    .catch(e=>{
      console.log(e)
    })
    getList(1);
  }
})


commentsListResult.addEventListener('click', (e)=>{
  if (e.target.classList.contains('updateComments')) {
    let ud = e.target;
    let ud_s = ud.parentElement.previousElementSibling.previousElementSibling;

    let c = ud_s.innerHTML;
    // ud_s.innerHTML = `<textarea>${c}</textarea>`;

    // prompt("수정할 내용 입력")
    document.getElementById("message-text").value=c;

    
  }
})

modal_change.addEventListener("click", ()=> {
  let m = document.getElementById("message-text").value
   
  let p = document.getElementById("data-board-num")

  const f1 = new FormData();
  f1.append("boardContents",m);
  f1.append("boardNum",p);

   fetch("./updateComments",{
    method:'POST',
    body:f1
   })
   .then(result => result.text())
   .then(result => {
      if(result.trim()>'0'){
        alert("수정되었습니다.")
      }
   })
   .catch(e=>{
    alert("서버오류")
   })
})