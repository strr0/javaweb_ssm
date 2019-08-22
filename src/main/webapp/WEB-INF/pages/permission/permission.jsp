<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/8/21
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="blank"></div>
<div style="float: right; margin-right: 10px;">
    <a href="logout">注销</a>
</div>
<c:set var="adminName" value="${sessionScope.nameKey}"></c:set>
<div class="input_item">
    <font size="5"> 欢迎登录, ${adminName} </font>
</div>
<div class="show_item">
    <c:if test="${!empty permissionKey}">
        权限列表
        <table border="1">
            <tr>
                <th style="width: 100px;">权限名</th>
                <th style="width: 100px;">描述</th>
                <th style="width: 100px;">url</th>
                <th style="width: 80px;">
                    <button class="bt_user_add" onclick="insertPage('permissionadd')">添加权限</button>
                </th>
            </tr>
            <c:forEach var="permission" items="${permissionKey}">
                <tr>
                    <td>${permission.name}</td>
                    <td>${permission.description}</td>
                    <td>${permission.url}</td>
                    <td>
                        <div style="overflow: hidden; width: 80px;">
                            <div style="float: left; width: 40px;">
                                <button class="bt_user_change" onclick="toUpdatePermission('${permission.name}')">修改</button>
                            </div>
                            <div style="float: left; width: 40px;">
                                <button class="bt_user_delete" onclick="toDeletePermission('${permission.name}')">删除</button>
                            </div>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${!empty message}">
        ${message}
    </c:if>
</div>
</body>
</html>
