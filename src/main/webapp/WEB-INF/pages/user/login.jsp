<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/19
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <%--<title>Title</title>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css" />--%>
</head>
<body>
<%--<div class="box">--%>
    <div class="blank"></div>
    <div class="home_bt"><a href="main">返回</a></div>
    <form action="login" method="post">
        <div class="input_item">
            <font size="5">登录用户</font>
        </div>
        <div class="input_item">
            <div class="input_field">用户名: </div>
            <div class="input_field"><input type="text" id="login_name" name="username" /></div>
        </div>
        <div class="input_item">
            <div class="input_field">密码: </div>
            <div class="input_field"><input type="password" id="login_pwd" name="password" /></div>
        </div>
        <div class="input_item">
            <div id="login_error" style="color: red">
                <c:if test="${!empty message}">
                    ${message}
                </c:if>
            </div>
        </div>
        <div class="input_item">
            <div class="input_field"><input type="submit" class="bt1" value="登录" /></div>
            <div class="input_field"><input type="button" class="bt1" value="取消" onclick="location.href='login'" /></div>
        </div>
    </form>
    <div class="blank"></div>
<%--</div>--%>

</body>
</html>

