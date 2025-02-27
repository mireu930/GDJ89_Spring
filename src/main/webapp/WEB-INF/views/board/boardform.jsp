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
			<form class="row g-3" action = "" method = "post">
			  <div class="col-md-4">
			    <div class="input-group has-validation">
			      <!-- <span class="input-group-text" id="inputGroupPrepend3">@</span> -->
			      <input type="hidden" name=boardNum value="${board.boardNum}"  class="form-control is-invalid" id="validationServer01" aria-describedby="inputGroupPrepend3 validationServerUsernameFeedback" required>
			    </div>
			    
			    <div class="input-group has-validation">
			      <label for="boardTitle" class="form-label">제목</label>
			      <input type="text" name="boardTitle" value="${board.boardTitle}"  class="form-control is-invalid" id="validationServer02" aria-describedby="inputGroupPrepend3 validationServerUsernameFeedback" required>
			      <div id="validationServerServer02Feedback" class="invalid-feedback">
			        Please choose a detail.
			      </div>
			    </div>
			  </div>
			  <div class="col-md-4">
			    <label for="boardContent" class="form-label">내용</label>
			    <div class="input-group has-validation">
			      <!-- <span class="input-group-text" id="inputGroupPrepend3">@</span> -->
			      <input type="text" name="boardContent" value="${board.boardContent}" class="form-control is-invalid" id="validationServerUsername" aria-describedby="inputGroupPrepend3 validationServerUsernameFeedback" required>
			      <div id="validationServerUsernameFeedback" class="invalid-feedback">
			        Please choose a detail.
			      </div>
			    </div>
			  </div>
			   <input type="hidden" name="user_name" value = "sss" class="form-control is-invalid" id="validationServerUsername" aria-describedby="inputGroupPrepend3 validationServerUsernameFeedback" required>
			  <div class="col-12">
			    <button class="btn btn-primary" type="submit">수정</button>
			    <a href="./list" class ="btn btn-outline-danger">취소</a>	
			  </div>
			</form>
		</div>
	</div>
	<script src="/resources/JS/notice/update.js"></script>
	<c:import url="/WEB-INF/views/template/layout_footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/template/boot_js.jsp"></c:import>
</body>
</html>