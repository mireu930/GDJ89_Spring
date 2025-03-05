const files = document.getElementById("files");
const btn1 = document.getElementById("btn1");
const del = document.getElementsByClassName("del");

let count =0;

files.addEventListener("click", function(e) {
  if(e.target.classList.contains('del')){
    console.log("click");
    del.parentNode.remove();
  }
})

// for(let i of del){
//   i.addEventListener("click", function(){
//     console.log("del");

//   })
// }

btn1.addEventListener("click", function(){
  if(count>4){
    alert('최대5개만 가능');
    return;
  }
  
  let div = document.createElement("div");

  let col = document.createAttribute('class');
  col.value = 'col-md-3';

  div.setAttributeNode(col);

  
  let label = document.createElement('label');
  let formLabel = document.createAttribute('class');
  formLabel.value = 'form-label';
  label.innerHTML = '첨부파일';
  
  label.setAttributeNode(formLabel);
  
  let f = document.createAttribute('for');
  f.value = "attach"+count;
  
  label.setAttributeNode(f);
  
  div.append(label);
  
  let child = document.createElement('input');
  let tp = document.createAttribute('type');
  tp.value='file';
  let na = document.createAttribute('name');
  na.value='attaches';
  let c = document.createAttribute('class');
  c.value = 'form-control';
  let d = document.createAttribute('id');
  d.value = "attach"+count;
  
  child.setAttributeNode(tp);
  child.setAttributeNode(na);
  child.setAttributeNode(c);
  child.setAttributeNode(d);

  div.append(child);

  let x = document.createElement('button');
  x.type="button";
  
  x.innerHTML='X'
 
  x.classList.add("btn", "btn-danger", "del");
  div.append(x);
  
  files.append(div);
  count++;
})