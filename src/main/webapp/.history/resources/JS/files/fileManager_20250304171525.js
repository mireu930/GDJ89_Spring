const files = document.getElementById("files");
const btn1 = document.getElementById("btn1");

for(let i=0; i<5;i++){
btn1.addEventListener("click", function(){
  let div = document.createElement("div");

  let col = document.createAttribute('class');
  col.value = 'col-md-3';

  div.setAttributeNode(col);

  
  let label = document.createElement('label');
  let formLabel = document.createAttribute('class');
  formLabel.value = 'form-label';
  label.innerHTML = '첨부파일';
  
  label.setAttributeNode(formLabel);
  div.append(label);
  
  let child = document.createElement('input');
  let tp = document.createAttribute('type');
  tp.value='file';
  let na = document.createAttribute('name');
  na.value='attaches';
  let c = document.createAttribute('class');
  c.value = 'form-control';
  
  child.setAttributeNode(tp);
  child.setAttributeNode(na);
  child.setAttributeNode(c);
  
  div.append(child);

  let x = document.createElement('button');
  let ty = document.createAttribute('type');
  ty.value = 'button';
  x.classList.add("btn", "btn-danger");


  
  files.append(div);
})

}