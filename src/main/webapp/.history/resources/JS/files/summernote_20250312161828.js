$('#detail').summernote({
  collbacks:{
    onImageUpload:function(files){
      console.log(files)
    }
  }
})
