$('#detail').summernote({
  collbacks:{
    onImageUpload:function(files){
      console.log(files[0])

      let f = new FormData();
      f.append("uploadFile",files)

      fetch("./detailFiles",{
        method:'POST',
        
      })
    }
  }
})
