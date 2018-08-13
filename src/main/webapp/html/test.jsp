<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"  isELIgnored="false" %>
<html>
<head>
    <title>test</title>
</head>
<body>
<h3>id:<c:out value="${requestScope.id}"></c:out> </h3>
<br>
<h3>name:${name}</h3>
<br>
hello
</body>
</html>
