<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/index.jsp">Back to main manu</a>

<br/>
<br/>
<h1>User List</h1>
<c: if test="${!empty listUsers}">
    <table class="tg">

        <c: forEach items="${listUsers}" var ="userStore">
        <tr>
            <th WIDTH="80">ID</th>
            <th width="120">NAME</th>
            <th width="120">SECOND NAME</th>
            <th width="40">AGE</th>
            <th width="40">GENDOR</th>
            <th width="60">EDIT</th>
            <th width="60">DELETE</th>
        </tr>
        </c: forEach>
        <tr>
            <td>${userStore.id}</td>
            <td>${userStore.name}</td>
            <td>${userStore.secondName}</td>
            <td>${userStore.age}</td>
            <%--<td>${userStore.gendor}</td>--%>
            <td><a href="<c:url value='/edit/${userStore.id}'></c:url>">">Edit</a></td>
            <td><a href="<c:url value='/remove/${userStore.id}'/>">">Delete</a></td>
        </tr>
    </table>
</c: if>
<h1>Add userStore</h1>

</body>
</html>
