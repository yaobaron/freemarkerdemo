<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>列表页</title>
</head>
<style>
    td{text-align: center; height: 30px;}
    .code{width:40px }
    .username{width: 80px}
    .address{width: 150px}
    .link{width: 100px}
</style>
<body>
    <h3>欢迎来到！</h3>
    <a href="/user/add">添加新用户</a>
    <br>
    <br>
    <table>
        <thead>
            <tr>
                <td class="code">编号</td>
                <td class="username">姓名</td>
                <td class="address">地址</td>
                <td class="link">详情</td>
            </tr>
        </thead>
        <tbody>
            <#list users as user>
            <tr>
                <td class="code">${user.userId}</td>
                <td class="username">${user.username}</td>
                <td class="address">${user.address}</td>
                <td class="link"><a href="/user/${user.userId}" target="_blank">查看详情</a></td>
            </tr>
            </#list>
        </tbody>
    </table>
</body>
</html>