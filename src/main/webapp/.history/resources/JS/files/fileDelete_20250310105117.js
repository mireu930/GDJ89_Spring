const fileDelete = document.getElementsByClassName("files-delete");

for( let c of fileDelete) {
  c.addEventListener("click", () => {
    console.log("delete");
  })

}
