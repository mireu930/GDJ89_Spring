const pages = document.getElementsByClassName("pages");
const list_form = document.getElementById("list_form");
const page_num = document.getElementById("page_num");

// let i=0;
for(let i of pages){
  i.addEventListener("click",function(){
    // console.log(pages[i]);
    // console.log(i.data-page-num);
    console.log(i.getAttribute("data-page-num"));
    page_num.value=i.getAttribute("data-page-num")
    list_form.submit();

  })
}