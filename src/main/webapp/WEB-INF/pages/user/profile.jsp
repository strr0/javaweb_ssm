<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/19
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css" />
</head>
<body>
<div class="box">
    <div class="blank"></div>
    <div style="float: right; margin-right: 10px;">
        <c:set var="login" value="${sessionScope.nameKey}"></c:set>
        <c:if test="${!empty login}" var="flag">
            ${login} <a href="logout">注销</a>
        </c:if>
        <c:if test="${not flag}">
            未登录
        </c:if>
    </div>
    <div class="show_item">

        <c:set var="user" value="${userKey}"></c:set>
        <c:if test="${!empty user}">
            <font size="5">用户信息</font>
            <div class="blank"></div>
            <div style="margin-left: 50px">
                <table>
                    <tr>
                        <td>用户名: </td>
                        <td>${user.username}</td>
                    </tr>
                    <tr>
                        <td>性别: </td>
                        <td>${user.sex}</td>
                    </tr>
                    <tr>
                        <td>年龄: </td>
                        <td>${user.age}</td>
                    </tr>
                    <tr>
                        <td>爱好: </td>
                        <td>${user.likes}</td>
                    </tr>
                    <tr>
                        <td>个人签名: </td>
                        <td>${user.tag}</td>
                    </tr>
                </table>
            </div>
        </c:if>
    </div>
    <div class="blank"></div>
    <div style="margin-left: 10px;"><a href="messages">留言板</a></div>
    <div class="blank"></div>
</div>
<script src="resources/js/dataCheck.js"></script>
</body>
</html>

