const pages = document.getElementsByClassName("pages");
// let i=0;
for(let i of pages){
  i.addEventListener("click",function(){
    console.log(pages[i]);
    // i++;

  })
}