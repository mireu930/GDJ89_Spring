<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		/* const isDelete = confirm("삭제하시겠습니까?"); */
		
		if(confirm("삭제하시겠습니까?")){
			alert('${result}');
			location.href='${path}';
		} else {
			alert('삭제실패');
			location.href='./mypage';
		}
	</script>
</head>
<body>
</body>
</html>