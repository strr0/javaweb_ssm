<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/19
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<%--    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css" />--%>
</head>
<body>
<%--<div class="box">--%>
    <div class="blank"></div>
    <div style="float: right; margin-right: 10px;">
        <a href="logout">注销</a>
    </div>
    <c:set var="users" value="${usersKey}"></c:set>
    <c:set var="adminName" value="${sessionScope.nameKey}"></c:set>
    <div class="input_item">
        <font size="5"> 欢迎登录, ${adminName} </font>
    </div>
    <div class="show_item">
        <c:if test="${!empty users}" var="flag">
            用户列表
            <table border="1">
                <tr>
                    <th style="width: 100px;">用户名</th>
                    <th style="width: 100px;">性别</th>
                    <th style="width: 100px;">年龄</th>
                    <th style="width: 120px;">爱好</th>
                    <th style="width: 80px;">
                        <button class="bt_user_add" onclick="insertPage('register')">添加用户</button>
                    </th>
                </tr>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td><c:out value="${user.username}"></c:out></td>
                        <td><c:out value="${user.sex}"></c:out></td>
                        <td><c:out value="${user.age}"></c:out></td>
                        <td><c:out value="${user.likes}"></c:out></td>
                        <td>
                            <div style="overflow: hidden; width: 80px;">
                                <div style="float: left; width: 40px;">
                                    <button class="bt_user_change" onclick="toUpdateUser('${user.id}')">修改</button>
                                </div>
                                <div style="float: left; width: 40px;">
                                    <button class="bt_user_delete" onclick="toDeleteUser('${user.id}')">删除</button>
                                </div>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <c:if test="${not flag}">
            暂无用户注册
        </c:if>
        <c:if test="${!empty message}">
            ${message}
        </c:if>
    </div>
<%--    <div style="margin-left: 10px;"><a href="messages">留言板</a></div>
    <div class="blank"></div>--%>
<%--</div>--%>
</body>
</html>

