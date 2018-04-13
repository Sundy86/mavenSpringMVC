<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>文件上传</title>
</head>
<body>
<form method="post" action="/fileupload" enctype="multipart/form-data">
<center>
    <input type="file" name="file1" />
    别名：<input type="text" name="alais" />
    <br />
    <input type="file" name="file2" />
    别名：<input type="text" name="alais" />
    <br />
    <input type="file" name="file3" />
    别名：<input type="text" name="alais" />
    <br><br>
    <input type="submit" value="上传" />
</center>
</form>
</body>
</html>