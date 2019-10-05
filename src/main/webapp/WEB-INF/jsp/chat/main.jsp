<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채팅</title>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script>
	function sendChatMessage(form) {
		form.writer.value = form.writer.value.trim();

		if(form.writer.value.length == 0) {
			alert('작성자를 입력해주세요.');
			form.writer.focus();

			return false;
		}

		form.body.value = form.body.value.trim();

		if(form.body.value.length == 0) {
			alert('내용을 입력해주세요.');
			form.body.focus();

			return false;
		}

		// 서버로 전송.
		$.post('./addMessage', {
			writer : form.writer.value,
			body : form.body.value
		}, function(data) {
			//응답 콜백 함수.
			if(data.msg) {
				alert(data.msg);
			}
		}, 'json');

		// 다시 채팅의 내용 입력창으로 포커싱 돌리기.
		form.body.value = '';
		form.body.focus();
	}
</script>
</head>
<body>
	<h1>채팅</h1>
	
	<form onsubmit="sendChatMessage(this); return false;">
		<input type="text" name="writer" placeholder="작성자">
		<input type="text" name="body" placeholder="내용">
		<input type="submit" value="작성">
	</form>
</body>
</html> 