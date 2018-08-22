<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>登录页面</title>
    </head>

    <body>
        <form action="/loginUser" method="post">
            请输入用户名：<input type="text" name="username"/><br>
            请输入密 码：<input type="password" name="password"/><br>
            <input type="submit" value="提交"/>
        </form>
    </body>
</html>
