<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<c:import url="/WEB-INF/views/template/boot_css.jsp"></c:import>
	<c:import url="/WEB-INF/views/template/summernote.jsp"></c:import>
</head>
<body>
	<c:import url="/WEB-INF/views/template/layout_header.jsp"></c:import>
	<div class = "container-fluid my-5">
		<div class = "row col-md-8 offset-md-2">
			<form class="row g-3" action = "./add" method = "post" enctype="multipart/form-data">
			  <div class="col-md-4">
			    <label for="productName" class="form-label">상품이름</label>
			    <div class="input-group has-validation">
			      <input type="text" name="productName"  class="form-control is-invalid" id="validationServer02" aria-describedby="inputGroupPrepend3 validationServerUsernameFeedback" required>
			      <div id="validationServerServer02Feedback" class="invalid-feedback">
			        상품이름을 입력하세요.
			      </div>
			    </div>
			  </div>
			  <div class="col-md-4">
			    <label for="productDetail" class="form-label">상품상세설명</label>
			    <div class="input-group has-validation">
			      <!-- <span class="input-group-text" id="inputGroupPrepend3">@</span> -->
			      <input type="text" name="productDetail" class="form-control is-invalid" id="detail" aria-describedby="inputGroupPrepend3 validationServerUsernameFeedback" required>
			      <!-- <div id="validationServerUsernameFeedback" class="invalid-feedback">
			        상품상세설명을 입력하세요.
			      </div> -->
			    </div>
			  </div>
			  <div class="col-md-6">
			    <label for="productRate" class="form-label">이자율</label>
			    <input type="text" name = "productRate" class="form-control is-invalid" id="validationServer03" aria-describedby="validationServer03Feedback" required>
			    <div id="validationServer03Feedback" class="invalid-feedback">
			      이자율을 입력하세요.
			    </div>
			  </div>
			  <div class="col-md-3">
			    <label for="productDate" class="form-label">상품기간</label>
			    <input type="date" name ="productDate" class="form-control is-invalid" id="validationServer04" aria-describedby="validationServer03Feedback" required>
			    <div id="validationServer04Feedback" class="invalid-feedback">
			      상품기간을 입력하세요.
			    </div>
			  </div>
			  <div class="col-md-3">
			    <label for="productImage" class="form-label">상품이미지</label>
			    <input type="file" name ="productImage" class="form-control" id="validationServer04" aria-describedby="validationServer03Feedback">
			  </div>
			  <div class="col-12">
			    <div class="form-check">
			      <input class="form-check-input is-invalid" type="checkbox" value="" id="invalidCheck3" aria-describedby="invalidCheck3Feedback" required>
			      <label class="form-check-label" for="invalidCheck3">
			        상품등록에 동의합니다.
			      </label>
			      <div id="invalidCheck3Feedback" class="invalid-feedback">
			        상품등록하기전에 동의를 눌러주세요.
			      </div>
			    </div>
			  </div>
			  <div class="col-12">
			    <button class="btn btn-primary" type="submit">등록</button>
			  </div>
			</form>
		</div>
	</div>
	<script src="/resources/JS/products/add.js"></script>
	<script src="/resources/JS/files/summernote.js"></script>
	<c:import url="/WEB-INF/views/template/layout_footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/template/boot_js.jsp"></c:import>
	
</body>
</html>