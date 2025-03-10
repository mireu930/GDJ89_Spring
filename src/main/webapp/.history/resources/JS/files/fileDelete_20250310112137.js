const fileDelete = document.getElementsByClassName("files-delete");

for( let c of fileDelete) {
  c.addEventListener("click", () => {
    console.log("delete");

    let confirm1 = confirm("정말 삭제하시겠습니까?");

    if(confirm1){
      let num = c.getAttribute("data-file-num")
      let kind = c.getAttribute("data-kind")

      console.log(num);
      console.log(kind);

      let url = `/${kind}/fileDelete`;


      fetch()
      .then()
    }
  })

}
