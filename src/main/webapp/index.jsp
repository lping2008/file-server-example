<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="application/json; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	File Server Exmaple

	<form action="${pageContext.request.contextPath}/pic/upload"
		method="post" enctype="multipart/form-data">
		<caption>
			<b>添加图片</b>
		</caption>
		<tr>
			<td>商品图片</td>
			<td><input type="file" name="uploadFile"></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="添加商品">
				<input type="reset" value="取消"></td>
		</tr>
	</form>
</body>
</html>