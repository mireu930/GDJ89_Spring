$('#detail').summernote({
  callbacks:{
    onImageUpload:function(files){
      console.log(files[0])

      let f = new FormData();
      f.append("uploadFile",files[0])

      fetch("./detailFiles",{
        method:'POST',
        body:f
      })
      .then(r=>r.text())
      .then(r=>{
        $('#detail').summernote('insertNode', r.trim());
      })
    }
  }
})
