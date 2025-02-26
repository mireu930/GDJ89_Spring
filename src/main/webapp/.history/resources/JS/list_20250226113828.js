const pages = document.getElementsByClassName("pages");

for(let i of pages){
  pages[i].addEventListener("click",function(){
    console.log(pages[i]);
  })
}