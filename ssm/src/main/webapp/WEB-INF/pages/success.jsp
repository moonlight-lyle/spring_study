<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <center>
        <h1>账户列表</h1>
        <%--table>tr*10>td*10  按住tab 10行10列表格就出现了--%>
        <table border="1px" width="500px">
            <tr>
                <td>账户id</td>
                <td>账户名称</td>
                <td>账户金额</td>
            </tr>
            <c:forEach items="${list}" var="a">
                <tr>
                    <td>${a.id}</td>
                    <td>${a.name}</td>
                    <td>${a.money}</td>
                </tr>
            </c:forEach>
        </table>
    </center>
</body>
</html>
