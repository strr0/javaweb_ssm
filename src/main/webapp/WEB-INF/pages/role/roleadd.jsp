<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/21
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="blank"></div>
<div style="float: right; margin-right: 10px;"><a href="main">返回</a></div>
<form id="role_form">
    <div class="input_item">
        <font size="5">创建角色</font>
    </div>
    <div class="input_item">
        <div class="input_field">角色名：</div>
        <div class="input_field"><input type="text" id="name" name="name" onblur="isRoleName(this.value)" placeholder="请输入角色名" autocomplete="off" /></div>
        <div class="input_error" id="name_error"></div>
    </div>
    <div class="input_item">
        <div class="input_field">角色权限：</div>
        <div class="input_field">
            <div>
                个人信息<input type="checkbox" name="permissions" onchange="isPermission()" value="profile_priv" />
            </div>
            <div>
                所有用户<input type="checkbox" name="permissions" onchange="isPermission()" value="edituser_priv" />
            </div>
            <div>
                留言板<input type="checkbox" name="permissions" onchange="isPermission()" value="message_priv" />
            </div>
            <div>
                角色管理<input type="checkbox" name="permissions" onchange="isPermission()" value="role_priv" />
            </div>
        </div>
        <div class="input_error" id="permission_error"></div>
    </div>
    <div class="input_item">
        <div class="input_field">
            <input type="button" class="bt1" value="注册" onclick="roleAdd()" />
        </div>
        <div class="input_field">
            <input type="button" class="bt1" onclick="" value="取消" />
        </div>
    </div>
</form>

</body>
</html>
