<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<c:import url="/WEB-INF/views/template/boot_css.jsp"></c:import>
</head>
<body>
	<c:import url="/WEB-INF/views/template/layout_header.jsp"></c:import>
	<div class = "container-fluid my-5">
		<div class = "row col-md-8 offset-md-2">
			<form class="row g-3" action = "./update" method = "post" enctype="multipart/form-data">
			  <div class="col-md-4">
			    <div class="input-group has-validation">
			      <!-- <span class="input-group-text" id="inputGroupPrepend3">@</span> -->
			      <input type="hidden" name="productNum" value="${dto.productNum}"  class="form-control is-invalid" id="validationServer01" aria-describedby="inputGroupPrepend3 validationServerUsernameFeedback" required>
			    </div>
			    
			    <div class="input-group has-validation">
			      <label for="productNum" class="form-label">상품이름</label>
			      <input type="text" name="productName" value="${dto.productName}"  class="form-control is-invalid" id="validationServer02" aria-describedby="inputGroupPrepend3 validationServerUsernameFeedback" required>
			      <div id="validationServerServer02Feedback" class="invalid-feedback">
			        Please choose a detail.
			      </div>
			    </div>
			  </div>
			  <div class="col-md-4">
			    <label for="productDetail" class="form-label">상품상세설명</label>
			    <div class="input-group has-validation">
			      <!-- <span class="input-group-text" id="inputGroupPrepend3">@</span> -->
			      <input type="text" name="productDetail" value="${dto.productDetail }" class="form-control is-invalid" id="validationServerUsername" aria-describedby="inputGroupPrepend3 validationServerUsernameFeedback" required>
			      <div id="validationServerUsernameFeedback" class="invalid-feedback">
			        Please choose a detail.
			      </div>
			    </div>
			  </div>
			  <div class="col-md-6">
			    <label for="productRate" class="form-label">이자율</label>
			    <input type="text" name = "productRate" value="${dto.productRate}" class="form-control is-invalid" id="validationServer03" aria-describedby="validationServer03Feedback" required>
			    <div id="validationServer03Feedback" class="invalid-feedback">
			      Please provide a rate.
			    </div>
			  </div>
			   <div class="col-md-3">
			    <label for="productDate" class="form-label">상품기간</label>
			    <input type="date" name ="productDate" value ="${dto.productDate}" class="form-control is-invalid" id="validationServer04" aria-describedby="validationServer03Feedback" required>
			    <div id="validationServer04Feedback" class="invalid-feedback">
			      Please select a date.
			    </div>
			  </div>
			  <div class="col-md-3">
			    <label for="productImage" class="form-label">상품이미지</label>
			    <input type="file" name ="productImage" class="form-control is-invalid" id="productImages" required>
			  </div> 
			  <div>
			  	${dto.productFileDTO.oldName}
			  	<span class="btn text-danger">x</span>
			  </div>
			  <div class="col-12">
			    <button class="btn btn-primary" type="submit">수정</button>
			    <a href="./list" class ="btn btn-outline-danger">취소</a>	
			  </div>
			</form>
		</div>
	</div>
	<script src="/resources/JS/products/update.js"></script>
	<c:import url="/WEB-INF/views/template/layout_footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/template/boot_js.jsp"></c:import>
</body>
</html>