<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		/* const isDelete = confirm("삭제하시겠습니까?"); */
		
		/* if(confirm("삭제하시겠습니까?")){
			alert('${result}');
			location.href='${path}';
		} else {
			alert('삭제실패');
			location.href='./mypage';
		} */
		
		 var result = "${result}";
		    var path = "${path}";

		    if(result === "삭제성공") {
		        if(confirm("삭제하시겠습니까?")) {
		            alert(result);  // 삭제 성공 메시지
		            location.href = path;
		        } else {
		            alert('삭제취소');
		            location.href = './mypage';
		        }
		    } else {
		        alert(result);  // 삭제 실패 메시지
		        location.href = path;
		    }
	</script>
</head>
<body>
</body>
</html>