<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--引入js--%>
    <script src="js/jquery.min.js"></script>
</head>
<body>
    <h1>一,返回值分类 </h1>
    <a href="response/testReturnString">返回String</a><br/>
    <a href="response/testReturnVoid">返回void</a><br/>
    <a href="response/testModelAndView">返回ModelAndView</a><br/>
    <h1>二,转发和重定向 </h1>
    <a href="response/forwardToPage">转发到页面</a><br/>
    <a href="response/forwardToController">转发到其它Controller</a><br/>
    <a href="response/redirectToPage">重定向到页面</a><br/>
    <a href="response/redirectToController">重定向到其它Controller</a><br/>
    <h3>三,响应json </h3>
    <input id="btnId" type="button" value="发送Ajax"/>
    <input id="btnId02" type="button" value="发送Ajax02"/>
</body>
<script>
    $("#btnId").click(function () {
        // 发送Ajax请求服务器 获得json 参数2: 是key:value的对象
        $.post('response/testJson',{username:"ls",password:"6666666"},function (result) {
            // JSON.stringify(): 把json对象转成字符串
            alert(JSON.stringify(result));
        },"json");
    });

    $("#btnId02").click(function () {
        // 发送Ajax请求服务器 获得json 参数2: 是key:value的对象
        $.post('response/testJson02',function (result) {
            alert(JSON.stringify(result));
        },'json');
    });
</script>

</html>
