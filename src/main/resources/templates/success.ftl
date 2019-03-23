<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加成功</title>
</head>
    <body>
        <h4>添加成功！</h4><a href="http://localhost:8080/user/list" class="alert-link">三秒后自动跳转！</a>
    </body>
    <script>
        setTimeout('location.href="http://localhost:8080/user/list"',3000)
    </script>
</html>