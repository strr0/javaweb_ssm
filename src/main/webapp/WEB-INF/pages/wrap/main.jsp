<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/20
  Time: 8:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" isErrorPage="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css" />
</head>
<body>
    <div class="main_wrap">
        <c:set var="username" value="${sessionScope.nameKey}"></c:set>
        <c:if test="${!empty username}" var="flag">
            <div class="main_label" id="label">
                <div class="label_select"><div onclick="insertPage('profile')">用户信息</div></div>
                <div class="label_select"><div onclick="insertPage('messages')">留言板</div></div>
                <div class="label_select"><div onclick="insertPage('users')">所有用户</div></div>
            </div>
        </c:if>
        <c:if test="${not flag}">
            <div class="main_label" id="label">
                <div class="label_select"><div onclick="insertPage('login')">登录</div></div>
                <div class="label_select"><div onclick="insertPage('register')">注册</div></div>
            </div>
        </c:if>
        <div id="demo" class="main_box">
            <div>
                <div style="margin: 40px 35px 0 35px;">
                    <img src="resources/img/hello.gif" style="width: 480px;" />
                </div>
                <div>
                    <center>
                        <h1>
                            <c:if test="${!empty message}" var="flag">
                                ${message}
                            </c:if>
                            <c:if test="${not flag}">
                                欢迎使用
                            </c:if>
                        </h1>
                    </center>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript" src="resources/js/script.js"></script>
</body>
</html>
