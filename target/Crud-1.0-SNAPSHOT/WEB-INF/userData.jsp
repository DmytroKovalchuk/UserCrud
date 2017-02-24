<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 22.02.2017
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Data</title>
</head>
<body>
<h1>User data</h1>
<table class="tg">
    <tr>
        <th width="60">id</th>
        <th width="120">name</th>
        <th width="120">secondName</th>
    </tr>
    <tr>
        <td>${userStore.id}</td>
        <td>${userStore.name}</td>
        <td>${userStore.secondName}</td>
    </tr>
</table>

</body>
</html>
