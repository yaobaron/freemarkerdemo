<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户详情</title>
    <style>
        td{height: 30px;}
        .left{width: 50px;}
        .right{width: 150px;}
    </style>
</head>
<body>
    <h3>用户详情</h3>
    <table>
        <tr><td class="left">编号：</td><td class="right">${user.userId}</td>
        <tr><td>姓名：</td><td>${user.username}</td>
        <tr><td>地址：</td><td>${user.address}</td>
        <tr><td>邮编：</td><td>${user.email}</td>
    </table>
</body>
</html>