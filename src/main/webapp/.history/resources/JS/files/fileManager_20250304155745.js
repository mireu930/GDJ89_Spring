const files = document.getElementById("files");
const btn1 = document.getElementById("btn1");

btn1.addEventListener("click", function(){
  let div = document.createElement("div");

  let col = document.createAttribute('class');
  col.value = 'col-md-3';

  div.setAttributeNode(col);

  files.prepend(div);

  let label = document.createElement('label');
  let formLabel = document.createAttribute('class');
  formLabel.value = 'form-label';
  label.innerHTML = '첨부파일';

  div.append(label);

  let child = document.createElement('input');
  let tp = document.createElement('type');
  tp.value='file';
  let na = document.createElement('name');
  na.value='attaches';
  let c = document.createElement('class');
  c.value = 'form-control';
  let ar = document.createElement('aria-describedby');



})