const pages = document.getElementsByClassName("pages");
const list_form = document.getElementById("list_form");
// let i=0;
for(let i of pages){
  i.addEventListener("click",function(){
    console.log(pages[i]);
    // i++;

  })
}