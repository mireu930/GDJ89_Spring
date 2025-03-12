$('#detail').summernote({
  collbacks:{
    onImageUpload:function(files){
      console.log(files[0])

      let f = new FormData();
      f.append("uploadFile",files[0])

      fetch("./detailFiles",{
        method:'POST',
        body:f
      })
      
    }
  }
})
