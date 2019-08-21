<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/21
  Time: 13:35
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
<div style="float: right; margin-right: 10px;"><a href="main">返回</a></div>
<c:if test="${!empty roleKey}">
    <form id="role_form">
        <div class="input_item">
            <font size="5">修改角色</font>
        </div>
        <div class="input_item">
            <div class="input_field">角色名：</div>
            <div class="input_field"><input type="text" id="name" name="name" value="${roleKey.name}" readonly /></div>
            <div class="input_error" id="name_error"></div>
        </div>
        <c:set var="permissions" value="${roleKey.permissions}"></c:set>
        <div class="input_item">
            <div class="input_field">角色权限：</div>
            <div class="input_field">
                <div>
                    个人信息<input type="checkbox" name="permissions" onchange="isPermission()" value="profile_priv" ${permissions.contains('个人信息') ? 'checked' : ''} />
                </div>
                <div>
                    所有用户<input type="checkbox" name="permissions" onchange="isPermission()" value="edituser_priv" ${permissions.contains('所有用户') ? 'checked' : ''} />
                </div>
                <div>
                    留言板<input type="checkbox" name="permissions" onchange="isPermission()" value="message_priv" ${permissions.contains('留言板') ? 'checked' : ''} />
                </div>
                <div>
                    角色管理<input type="checkbox" name="permissions" onchange="isPermission()" value="role_priv" ${permissions.contains('角色管理') ? 'checked' : ''} />
                </div>
            </div>
            <div class="input_error" id="permission_error"></div>
        </div>
        <div class="input_item">
            <div class="input_field">
                <input type="button" class="bt1" value="注册" onclick="upDateRole()" />
            </div>
            <div class="input_field">
                <input type="button" class="bt1" onclick="" value="取消" />
            </div>
        </div>
    </form>
</c:if>


</body>
</html>
