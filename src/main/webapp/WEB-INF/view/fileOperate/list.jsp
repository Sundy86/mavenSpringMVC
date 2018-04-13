<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>上传文件列表</title>
</head>
<body>
<h1>上传多个附件的列表</h1>
<c:forEach items="${result}" var="item">
    <c:forEach items="${item}" var="m">
        <c:if test="${m.key eq 'realName' }">
            上传文件原名: ${m.value }
            <br />
        </c:if>
        <c:if test="${m.key eq 'storeName' }">
            上传文件名（压缩后）: ${m.value }   <a href="/filedownload?filename=${m.value}">下载</a>
            <br />
        </c:if>
        <c:if test="${m.key eq 'path' }">
            上传文件路径: ${m.value }
            <br />
        </c:if>
        <c:if test="${m.key eq 'alais' }">
            别名: ${m.value }
            <br />
        </c:if>

    </c:forEach>

</c:forEach>
</body>
</html>