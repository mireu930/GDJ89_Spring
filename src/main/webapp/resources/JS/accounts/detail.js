/**
 * 
 */
 const frm = document.getElementById("frm");
const btn2 = document.getElementById("btn2");

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