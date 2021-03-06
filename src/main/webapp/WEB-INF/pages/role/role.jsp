<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/21
  Time: 13:01
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
    <c:if test="${!empty roles}">
        角色列表
        <table border="1">
            <tr>
                <th style="width: 80px;">角色名</th>
                <%-- 动态权限列表 --%>
                <c:forEach var="permission" items="${permissionKey}">
                    <th style="width: 80px;">${permission.description}</th>
                </c:forEach>
                <th style="width: 80px;">
                    <button class="bt_user_add" onclick="insertPage('roleadd')">添加角色</button>
                </th>
            </tr>
            <%-- role包含角色名和拥有的权限 --%>
            <c:forEach var="role" items="${roles}">
                <tr>
                    <td><c:out value="${role.name}"></c:out></td>
                    <%-- 判断角色是否拥有权限列表的权限 --%>
                    <c:forEach var="permission" items="${permissionKey}">
                        <td>${role.permissions.contains(permission.description) ? '✔':''}</td>
                    </c:forEach>
                    <td>
                        <div style="overflow: hidden; width: 80px;">
                            <div style="float: left; width: 40px;">
                                <button class="bt_user_change" onclick="toUpdateRole('${role.name}')">修改</button>
                            </div>
                            <div style="float: left; width: 40px;">
                                <button class="bt_user_delete" onclick="toDeleteRole('${role.name}')">删除</button>
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
