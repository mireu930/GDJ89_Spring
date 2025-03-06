const check = document.getElementsByClassName("check");
const checkAll = document.getElementById("checkAll");

checkAll.addEventListener("click",()=>{
  for(let c of check){
    c.checked= checkAll.checked;
  }
})