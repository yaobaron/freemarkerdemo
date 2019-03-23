<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>新建用户</title>
</head>
<body>
    <h3>新建用户</h3>
    <form action="/user/save" method="post">
        <label>姓名：</label><input type="text" name="username" /><br><br>
        <label>地址：</label><input type="text" name="address" /><br><br>
        <label>邮箱：</label><input type="text" name="email" /><br><br>
        <input type="submit" value="提交" />
    </form>

</body>
</html>